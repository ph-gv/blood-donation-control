package com.mycompany.projeto.ods.dao;
 
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.util.BancoDadosException;
import com.mycompany.projeto.ods.util.ConexaoBD;
 
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * DAO responsável por todas as operações de banco relacionadas à entidade Doacao.
 *
 * COMPATIBILIDADE COM SQLite:
 * Assim como no DoadorDAO, datas e horas são armazenadas e lidas como TEXT
 * no formato ISO 8601. LocalDate.toString() → "yyyy-MM-dd", LocalDate.parse() faz
 * o inverso. LocalTime.toString() → "HH:mm" ou "HH:mm:ss", LocalTime.parse() lida
 * com ambos os formatos sem configuração extra.
 *
 * REGRA DE NEGÓCIO — CAPACIDADE DIÁRIA:
 * O método verificarDisponibilidade() foi expandido para checar duas condições
 * independentes, na seguinte ordem:
 *   1. O horário exato já está ocupado naquele hemocentro naquele dia?
 *   2. O hemocentro já atingiu sua capacidade_diaria para aquele dia?
 * Se qualquer das duas condições falhar, o agendamento é bloqueado.
 * A mensagem de erro na DoacaoScreen é a mesma para ambos os casos, pois do ponto
 * de vista do usuário o resultado é o mesmo: "não há vaga disponível".
 */
public class DoacaoDAO {
 
    private static final Logger LOG = Logger.getLogger(DoacaoDAO.class.getName());
 
    // -------------------------------------------------------------------------
    // Verificação de disponibilidade (horário + capacidade diária)
    // -------------------------------------------------------------------------
 
    /**
     * Verifica se um agendamento pode ser realizado para o local, data e hora indicados.
     *
     * Retorna TRUE (disponível) apenas se AMBAS as condições forem satisfeitas:
     *   - O slot de horário exato ainda não está reservado (status 'agendado').
     *   - O total de agendamentos 'agendado' naquele local/data é menor que
     *     a capacidade_diaria do hemocentro.
     *
     * As duas verificações são feitas na MESMA conexão para garantir consistência:
     * se uma terceira pessoa estivesse agendando simultaneamente (improvável em desktop
     * monousuário, mas defensivamente correto), o estado lido seria coerente.
     *
     * @return true se o agendamento pode prosseguir, false caso contrário
     * @throws BancoDadosException se ocorrer falha de acesso ao banco
     */
    public boolean verificarDisponibilidade(int idLocal, LocalDate data, LocalTime horario) {
 
        String sqlHorario =
            "SELECT COUNT(*) FROM doacoes " +
            "WHERE id_local_coleta = ? AND data = ? AND horario = ? AND status = 'agendado'";
 
        String sqlContagem =
            "SELECT COUNT(*) FROM doacoes " +
            "WHERE id_local_coleta = ? AND data = ? AND status = 'agendado'";
 
        String sqlCapacidade =
            "SELECT capacidade_diaria FROM locais_coleta WHERE id = ?";
 
        try (Connection conn = ConexaoBD.getConnection()) {
 
            // --- Verificação 1: horário exato já está ocupado? ---
            try (PreparedStatement stmt = conn.prepareStatement(sqlHorario)) {
                stmt.setInt(1, idLocal);
                stmt.setString(2, data.toString());        // "yyyy-MM-dd"
                stmt.setString(3, horario.toString());     // "HH:mm" ou "HH:mm:ss"
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return false; // horário já reservado
                }
            }
 
            // --- Verificação 2: capacidade diária atingida? ---
            int agendadosNoDia = 0;
            try (PreparedStatement stmt = conn.prepareStatement(sqlContagem)) {
                stmt.setInt(1, idLocal);
                stmt.setString(2, data.toString());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    agendadosNoDia = rs.getInt(1);
                }
            }
 
            int capacidadeMaxima = 0;
            try (PreparedStatement stmt = conn.prepareStatement(sqlCapacidade)) {
                stmt.setInt(1, idLocal);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    capacidadeMaxima = rs.getInt("capacidade_diaria");
                }
            }
 
            // Disponível somente se ainda há vagas no dia
            return agendadosNoDia < capacidadeMaxima;
 
        } catch (SQLException e) {
            throw new BancoDadosException(
                "Erro ao verificar disponibilidade para o local id=" + idLocal, e
            );
        }
    }
 
    // -------------------------------------------------------------------------
    // Salvar agendamento
    // -------------------------------------------------------------------------
 
    /**
     * Insere um novo registro de doação/agendamento no banco.
     * Após a inserção, o ID gerado automaticamente pelo SQLite (AUTOINCREMENT)
     * é recuperado e definido no objeto Doacao via setIdDoacao(), mantendo o
     * objeto sincronizado com o estado do banco.
     *
     * @throws BancoDadosException se a inserção falhar
     */
    public void salvar(Doacao d) {
        String sql =
            "INSERT INTO doacoes (id_doador, id_local_coleta, data, horario, status) " +
            "VALUES (?, ?, ?, ?, ?)";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {
 
            stmt.setInt(1, d.getIdDoador());
            stmt.setInt(2, d.getIdLocalColeta());
            stmt.setString(3, d.getData().toString());    // "yyyy-MM-dd"
            stmt.setString(4, d.getHorario().toString()); // "HH:mm" ou "HH:mm:ss"
            stmt.setString(5, d.getStatus());
 
            stmt.executeUpdate();
 
            // Recupera o ID gerado pelo AUTOINCREMENT do SQLite
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                d.setIdDoacao(rs.getInt(1));
            }
 
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao salvar agendamento de doação", e);
        }
    }
 
    // -------------------------------------------------------------------------
    // Listar agendamentos por doador
    // -------------------------------------------------------------------------
 
    /**
     * Retorna todos os agendamentos de um doador, ordenados por data e horário.
     * Usada pela MinhasDoacoesScreen para popular a tabela de agendamentos.
     *
     * Em caso de falha, registra o erro e retorna lista vazia para não crashar a UI.
     *
     * @return lista de Doacao do doador (nunca null)
     */
    public List<Doacao> listarPorDoador(int idDoador) {
        List<Doacao> lista = new ArrayList<>();
        String sql =
            "SELECT * FROM doacoes WHERE id_doador = ? ORDER BY data, horario";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setInt(1, idDoador);
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                Doacao d = new Doacao();
                d.setIdDoacao(rs.getInt("id_doacao"));
                d.setIdDoador(rs.getInt("id_doador"));
                d.setIdLocalColeta(rs.getInt("id_local_coleta"));
                // SQLite armazena como TEXT "yyyy-MM-dd" → LocalDate.parse() converte
                d.setData(LocalDate.parse(rs.getString("data")));
                // SQLite armazena como TEXT "HH:mm" ou "HH:mm:ss" → LocalTime.parse() converte
                d.setHorario(LocalTime.parse(rs.getString("horario")));
                d.setStatus(rs.getString("status"));
                lista.add(d);
            }
 
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao listar doações do doador id=" + idDoador, e);
        }
        return lista;
    }
 
    // -------------------------------------------------------------------------
    // Atualizar status
    // -------------------------------------------------------------------------
 
    /**
     * Atualiza o status de um agendamento específico.
     * Valores válidos (definidos no schema.sql via CHECK): 'agendado', 'realizado', 'cancelado'.
     *
     * A verificação de se o status atual permite a transição (ex: não cancelar o que
     * já está cancelado) é responsabilidade da View (MinhasDoacoesScreen), que deve
     * checar o status antes de chamar este método.
     *
     * @throws BancoDadosException se a atualização falhar
     */
    public void atualizarStatus(int idDoacao, String novoStatus) {
        String sql = "UPDATE doacoes SET status = ? WHERE id_doacao = ?";
 
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
 
            stmt.setString(1, novoStatus);
            stmt.setInt(2, idDoacao);
            stmt.executeUpdate();
 
        } catch (SQLException e) {
            throw new BancoDadosException(
                "Erro ao atualizar status da doação id=" + idDoacao, e
            );
        }
    }
}