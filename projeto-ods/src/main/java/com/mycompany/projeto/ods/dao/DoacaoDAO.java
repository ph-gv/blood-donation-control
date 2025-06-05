package com.mycompany.projeto.ods.dao;

import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.util.ConexaoBD;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class DoacaoDAO {
    /**
     * Verifica se já existe um agendamento “agendado” para o mesmo hemocentro,
     * data e horário. Retorna true se não houver conflito.
     */
    public boolean verificarDisponibilidade(int idLocal, LocalDate data, LocalTime horario) {
        String sql = "SELECT COUNT(*) FROM doacoes " +
                     "WHERE id_local_coleta = ? AND data = ? AND horario = ? AND status = 'agendado'";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idLocal);
            stmt.setDate(2, Date.valueOf(data));
            stmt.setTime(3, Time.valueOf(horario));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            System.err.println("Erro em verificarDisponibilidade: " + e.getMessage());
        }
        return false;
    }

    /**
     * Insere um novo registro na tabela de doações.
     * Após inserir, seta o ID gerado no objeto Doacao.
     */
    public void salvar(Doacao d) {
        String sql = "INSERT INTO doacoes " +
                     "(id_doador, id_local_coleta, data, horario, status) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, d.getIdDoador());
            stmt.setInt(2, d.getIdLocalColeta());
            stmt.setDate(3, Date.valueOf(d.getData()));
            stmt.setTime(4, Time.valueOf(d.getHorario()));
            stmt.setString(5, d.getStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                d.setIdDoacao(rs.getInt(1));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar doação: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Retorna uma lista de Doacao de acordo com o ID do doador.
     */
    public List<Doacao> listarPorDoador(int idDoador) {
        List<Doacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM doacoes WHERE id_doador = ? ORDER BY data, horario";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDoador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doacao d = new Doacao();
                d.setIdDoacao(rs.getInt("id_doacao"));
                d.setIdDoador(rs.getInt("id_doador"));
                d.setIdLocalColeta(rs.getInt("id_local_coleta"));
                d.setData(rs.getDate("data").toLocalDate());
                d.setHorario(rs.getTime("horario").toLocalTime());
                d.setStatus(rs.getString("status"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar doações: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Atualiza o status de uma doação (por exemplo, para "cancelado" ou "realizado").
     */
    public void atualizarStatus(int idDoacao, String novoStatus) {
        String sql = "UPDATE doacoes SET status = ? WHERE id_doacao = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, idDoacao);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status da doação: " + e.getMessage());
        }
    }
}
