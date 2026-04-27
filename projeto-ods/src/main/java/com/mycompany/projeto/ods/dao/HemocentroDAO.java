package com.mycompany.projeto.ods.dao;

import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.util.BancoDadosException;
import com.mycompany.projeto.ods.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO responsável por todas as operações de banco relacionadas à entidade
 * Hemocentro.
 *
 * Este DAO é o mais simples dos três porque a tabela locais_coleta contém
 * apenas
 * campos do tipo INTEGER e VARCHAR — nenhuma data ou hora — portanto não requer
 * nenhuma conversão de tipo especial para o SQLite. As mudanças em relação ao
 * código original são apenas a substituição de System.err por Logger e
 * BancoDadosException.
 *
 * Nota sobre a ausência de métodos de inserção/atualização/exclusão:
 * Os hemocentros são dados de configuração da aplicação, inseridos pelo
 * schema.sql.
 * Para um sistema acadêmico, isso é suficiente. Se futuramente for necessário
 * gerenciá-los pela interface, basta adicionar os métodos aqui seguindo o mesmo
 * padrão dos outros DAOs.
 */
public class HemocentroDAO {

    private static final Logger LOG = Logger.getLogger(HemocentroDAO.class.getName());

    // -------------------------------------------------------------------------
    // Listar todos os hemocentros
    // -------------------------------------------------------------------------

    /**
     * Retorna todos os hemocentros cadastrados na tabela locais_coleta.
     * Usada pela DoacaoScreen para popular o JComboBox de seleção de local.
     *
     * Em caso de falha de leitura, registra o erro e retorna lista vazia.
     * A DoacaoScreen já trata lista vazia adicionando um item vazio no combo,
     * o que é um comportamento aceitável.
     *
     * @return lista de hemocentros (nunca null)
     */
    public List<Hemocentro> listarTodos() {
        List<Hemocentro> lista = new ArrayList<>();
        String sql = "SELECT * FROM locais_coleta";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearHemocentro(rs));
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao listar hemocentros", e);
        }
        return lista;
    }

    // -------------------------------------------------------------------------
    // Buscar hemocentro por ID
    // -------------------------------------------------------------------------

    /**
     * Busca um hemocentro pelo ID primário.
     * Usada pela MinhasDoacoesScreen para exibir o nome do hemocentro na tabela
     * de agendamentos do doador.
     *
     * @return o Hemocentro encontrado, ou null se não existir
     */
    public Hemocentro buscarPorId(int id) {
        String sql = "SELECT * FROM locais_coleta WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearHemocentro(rs);
            }

        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao buscar hemocentro id=" + id, e);
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Buscar hemocentro por nome
    // -------------------------------------------------------------------------

    /**
     * Busca um hemocentro pelo nome exato.
     *
     * Este método existe porque a DoacaoScreen usa um JComboBox<String> que
     * armazena
     * apenas o nome do hemocentro (não o objeto inteiro). Ao confirmar o
     * agendamento,
     * a tela recupera o nome selecionado e precisa obter o ID do hemocentro
     * correspondente
     * para salvar a doação. Buscar pelo nome exato é a ponte entre a UI e o banco
     * nesse fluxo.
     *
     * Limitação conhecida: se dois hemocentros tiverem exatamente o mesmo nome,
     * este método retorna apenas o primeiro. Para o escopo atual do projeto, com
     * hemocentros de nomes únicos inseridos pelo schema.sql, isso não é um
     * problema.
     *
     * @return o Hemocentro encontrado, ou null se não existir
     * @throws BancoDadosException se ocorrer falha de acesso ao banco
     */
    public Hemocentro buscarPorNome(String nome) {
        String sql = "SELECT * FROM locais_coleta WHERE nome = ?";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearHemocentro(rs);
            }

        } catch (SQLException e) {
            throw new BancoDadosException(
                    "Erro ao buscar hemocentro por nome: " + nome, e);
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Método auxiliar: converter ResultSet em Hemocentro
    // -------------------------------------------------------------------------

    /**
     * Converte a linha atual do ResultSet em um objeto Hemocentro.
     * Todos os campos são INTEGER ou VARCHAR, sem necessidade de conversão
     * especial.
     *
     * @throws SQLException propagada para o método chamador lidar
     */
    private Hemocentro mapearHemocentro(ResultSet rs) throws SQLException {
        Hemocentro h = new Hemocentro();
        h.setId(rs.getInt("id"));
        h.setNome(rs.getString("nome"));
        h.setEndereco(rs.getString("endereco"));
        h.setCapacidadeDiaria(rs.getInt("capacidade_diaria"));
        return h;
    }
}