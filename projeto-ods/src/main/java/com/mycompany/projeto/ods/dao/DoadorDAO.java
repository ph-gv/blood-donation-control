package com.mycompany.projeto.ods.dao;
 
import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.util.BancoDadosException;
import com.mycompany.projeto.ods.util.ConexaoBD;
 
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.mindrot.jbcrypt.BCrypt;
 
/**
 * DAO responsável por todas as operações de banco relacionadas à entidade Doador.
 *
 * COMPATIBILIDADE COM SQLite:
 * O SQLite não possui tipos DATE e TIME nativos como o MySQL. Ele armazena datas
 * e horas como TEXT no formato ISO 8601 ("yyyy-MM-dd" para data, "HH:mm:ss" para hora).
 * Por isso, todos os setDate()/setTime() do código original foram substituídos por
 * setString() usando LocalDate.toString() e LocalTime.toString(), que produzem
 * exatamente esse formato ISO. Na leitura, getString() + LocalDate.parse() faz o
 * caminho inverso.
 *
 * TRATAMENTO DE EXCEÇÕES:
 * System.err.println foi removido. Métodos que modificam dados (salvar, atualizar,
 * excluir) lançam BancoDadosException para que a View possa exibir a mensagem
 * de erro ao usuário via JOptionPane. Métodos de leitura (listar, buscar) que
 * retornam listas registram o erro no Logger e retornam lista vazia ou null,
 * pois uma lista vazia é um resultado aceitável para a UI nesses casos.
 */
public class DoadorDAO {
 
    private static final Logger LOG = Logger.getLogger(DoadorDAO.class.getName());
 
    // -------------------------------------------------------------------------
    // Método 1: Cadastrar doador
    // -------------------------------------------------------------------------
 
    /**
     * Persiste um novo doador no banco.
     * A senha é recebida em texto puro e convertida para hash BCrypt aqui,
     * antes de qualquer acesso ao banco.
     *
     * @throws BancoDadosException se ocorrer falha na inserção (ex: CPF duplicado)
     */
    public void salvar(Doador doador) {
        // Proteção extra: só faz o hash se a senha ainda não for um hash BCrypt.
        // Isso evita double-hashing caso o método seja chamado duas vezes por engano.
        if (!doador.getSenha().startsWith("$2a$")) {
            doador.setSenha(BCrypt.hashpw(doador.getSenha(), BCrypt.gensalt()));
        }
 
        String sql = "INSERT INTO doadores (nome, cpf, tipo_sanguineo, data_nascimento, senha) " +
                     "VALUES (?, ?, ?, ?, ?)";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getCpf());
            stmt.setString(3, doador.getTipoSanguineo());
            // LocalDate.toString() produz "yyyy-MM-dd", que é o formato TEXT do SQLite
            stmt.setString(4, doador.getDataNascimento().toString());
            stmt.setString(5, doador.getSenha());
 
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao salvar doador: " + e.getMessage(), e);
        }
    }
 
    // -------------------------------------------------------------------------
    // Método 2: Atualizar doador
    // -------------------------------------------------------------------------
 
    /**
     * Atualiza os dados editáveis do doador: nome, tipo sanguíneo e, opcionalmente, senha.
     *
     * CPF e data de nascimento são campos de identidade imutáveis — não devem ser
     * alterados após o cadastro. Por isso foram REMOVIDOS do UPDATE. A tela
     * EditarPerfilScreen também deve exibir o CPF como somente-leitura (setEditable(false)).
     *
     * Lógica da senha:
     * - Se a senha no objeto já começa com "$2a$", é um hash BCrypt existente → não refaz o hash.
     * - Se for texto puro (usuário digitou nova senha) → gera novo hash antes de salvar.
     *
     * @throws BancoDadosException se ocorrer falha na atualização
     */
    public void atualizar(Doador doador) {
        if (!doador.getSenha().startsWith("$2a$")) {
            doador.setSenha(BCrypt.hashpw(doador.getSenha(), BCrypt.gensalt()));
        }
 
        // Campos imutáveis (cpf, data_nascimento) deliberadamente ausentes do SQL
        String sql = "UPDATE doadores SET nome = ?, tipo_sanguineo = ?, senha = ? WHERE id = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getTipoSanguineo());
            stmt.setString(3, doador.getSenha());
            stmt.setInt(4, doador.getId());
 
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao atualizar doador id=" + doador.getId(), e);
        }
    }
 
    // -------------------------------------------------------------------------
    // Método 3: Excluir doador
    // -------------------------------------------------------------------------
 
    /**
     * Remove um doador pelo ID.
     * Atenção: como a tabela 'doacoes' tem FOREIGN KEY para 'doadores',
     * excluir um doador que possui doações agendadas/realizadas vai lançar
     * exceção de integridade referencial. Isso é comportamento correto.
     *
     * @throws BancoDadosException se ocorrer falha na exclusão
     */
    public void excluir(int id) {
        String sql = "DELETE FROM doadores WHERE id = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(1, id);
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao excluir doador id=" + id, e);
        }
    }
 
    // -------------------------------------------------------------------------
    // Método 4: Buscar por ID
    // -------------------------------------------------------------------------
 
    /**
     * Busca um doador pelo ID primário.
     *
     * @return o Doador encontrado, ou null se não existir
     */
    public Doador buscarPorId(int id) {
        String sql = "SELECT * FROM doadores WHERE id = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                return mapearDoador(rs);
            }
 
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao buscar doador id=" + id, e);
        }
        return null;
    }
 
    // -------------------------------------------------------------------------
    // Método 5: Listar todos
    // -------------------------------------------------------------------------
 
    /**
     * Retorna todos os doadores cadastrados.
     * Em caso de falha, registra o erro e retorna lista vazia (não lança exceção),
     * pois uma lista vazia é tratável pela UI sem crash.
     *
     * @return lista de doadores (nunca null)
     */
    public List<Doador> listarTodos() {
        List<Doador> doadores = new ArrayList<>();
        String sql = "SELECT * FROM doadores";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
 
            while (rs.next()) {
                doadores.add(mapearDoador(rs));
            }
 
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao listar doadores", e);
        }
        return doadores;
    }
 
    // -------------------------------------------------------------------------
    // Método 6: Autenticar (login)
    // -------------------------------------------------------------------------
 
    /**
     * Autentica um doador verificando CPF e senha.
     * A busca é feita pelo CPF (campo UNIQUE) e então BCrypt.checkpw() compara
     * a senha digitada com o hash armazenado.
     *
     * @return o Doador autenticado, ou null se CPF não encontrado ou senha incorreta
     * @throws BancoDadosException se ocorrer falha de conexão (para que a LoginScreen
     *         possa exibir "Erro ao conectar com o banco" ao usuário)
     */
    public Doador autenticar(String cpf, String senha) {
        String sql = "SELECT * FROM doadores WHERE cpf = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                Doador doador = mapearDoador(rs);
                // BCrypt.checkpw compara texto puro com hash de forma segura
                if (BCrypt.checkpw(senha, doador.getSenha())) {
                    return doador;
                }
            }
 
        } catch (SQLException e) {
            // Aqui lançamos exceção porque falha de conexão é diferente de
            // "CPF ou senha incorretos" — a LoginScreen trata os dois casos separados
            throw new BancoDadosException("Erro ao autenticar usuário", e);
        }
        return null;
    }
 
    // -------------------------------------------------------------------------
    // Método 7: Verificar CPF existente
    // -------------------------------------------------------------------------
 
    /**
     * Verifica se um CPF já está cadastrado.
     * Usado pelo CadastroScreen antes de salvar para evitar duplicidade.
     *
     * @return true se o CPF já existe, false caso contrário
     */
    public boolean verificarCpfExistente(String cpf) {
        String sql = "SELECT COUNT(*) FROM doadores WHERE cpf = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
 
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
 
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao verificar CPF", e);
        }
        return false;
    }
 
    // -------------------------------------------------------------------------
    // Método 8: Buscar por tipo sanguíneo
    // -------------------------------------------------------------------------
 
    /**
     * Retorna todos os doadores de um determinado tipo sanguíneo.
     *
     * @return lista de doadores filtrada (nunca null)
     */
    public List<Doador> buscarPorTipoSanguineo(String tipo) {
        List<Doador> doadores = new ArrayList<>();
        String sql = "SELECT * FROM doadores WHERE tipo_sanguineo = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                doadores.add(mapearDoador(rs));
            }
 
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao buscar doadores por tipo sanguíneo: " + tipo, e);
        }
        return doadores;
    }
 
    // -------------------------------------------------------------------------
    // Método auxiliar: converter ResultSet em Doador
    // -------------------------------------------------------------------------
 
    /**
     * Converte a linha atual do ResultSet em um objeto Doador.
     *
     * A data de nascimento é lida como String ("yyyy-MM-dd") e convertida para
     * LocalDate com LocalDate.parse(), que usa o formato ISO 8601 por padrão —
     * exatamente o mesmo formato que o SQLite armazena.
     *
     * @throws SQLException propagada para o método chamador lidar
     */
    private Doador mapearDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setId(rs.getInt("id"));
        doador.setNome(rs.getString("nome"));
        doador.setCpf(rs.getString("cpf"));
        doador.setTipoSanguineo(rs.getString("tipo_sanguineo"));
        // SQLite armazena como TEXT "yyyy-MM-dd" → LocalDate.parse() lê corretamente
        doador.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
        doador.setSenha(rs.getString("senha"));
        return doador;
    }
}