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

public class DoacaoDAO {

    private static final Logger LOG = Logger.getLogger(DoacaoDAO.class.getName());

    public boolean verificarDisponibilidade(int idLocal, LocalDate data, LocalTime horario) {

        String sqlHorario = "SELECT COUNT(*) FROM doacoes " +
                "WHERE id_local_coleta = ? AND data = ? AND horario = ? AND status = 'agendado'";

        String sqlContagem = "SELECT COUNT(*) FROM doacoes " +
                "WHERE id_local_coleta = ? AND data = ? AND status = 'agendado'";

        String sqlCapacidade = "SELECT capacidade_diaria FROM locais_coleta WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(sqlHorario)) {
                stmt.setInt(1, idLocal);
                stmt.setString(2, data.toString());
                stmt.setString(3, horario.toString());
                ResultSet rs = stmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    return false;
                }
            }

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

            return agendadosNoDia < capacidadeMaxima;

        } catch (SQLException e) {
            throw new BancoDadosException(
                    "Erro ao verificar disponibilidade para o local id=" + idLocal, e);
        }
    }

    public void salvar(Doacao d) {
        String sql = "INSERT INTO doacoes (id_doador, id_local_coleta, data, horario, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, d.getIdDoador());
            stmt.setInt(2, d.getIdLocalColeta());
            stmt.setString(3, d.getData().toString());
            stmt.setString(4, d.getHorario().toString());
            stmt.setString(5, d.getStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                d.setIdDoacao(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao salvar agendamento de doação", e);
        }
    }

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
                d.setData(LocalDate.parse(rs.getString("data")));
                d.setHorario(LocalTime.parse(rs.getString("horario")));
                d.setStatus(rs.getString("status"));
                lista.add(d);
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Erro ao listar doações do doador id=" + idDoador, e);
        }
        return lista;
    }

    public void atualizarStatus(int idDoacao, String novoStatus) {
        String sql = "UPDATE doacoes SET status = ? WHERE id_doacao = ?";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, idDoacao);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new BancoDadosException(
                    "Erro ao atualizar status da doação id=" + idDoacao, e);
        }
    }

    public void atualizar(Doacao d) {
        String sql = "UPDATE doacoes SET id_local_coleta = ?, data = ?, horario = ? WHERE id_doacao = ?";

        try (Connection conn = ConexaoBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d.getIdLocalColeta());
            stmt.setString(2, d.getData().toString());
            stmt.setString(3, d.getHorario().toString());
            stmt.setInt(4, d.getIdDoacao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new BancoDadosException("Erro ao atualizar agendamento id=" + d.getIdDoacao(), e);
        }
    }

    public void cancelar(int idDoacao) {
        atualizarStatus(idDoacao, "cancelado");
    }
}