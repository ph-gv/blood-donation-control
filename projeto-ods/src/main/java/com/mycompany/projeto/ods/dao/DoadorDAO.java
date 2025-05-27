package com.mycompany.projeto.ods.dao;

import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.util.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class DoadorDAO {
    // Método 1: Cadastrar doador
    public void salvar(Doador doador) {
        String sql = "INSERT INTO doadores (nome, cpf, tipo_sanguineo, data_nascimento, senha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getCpf());
            stmt.setString(3, doador.getTipoSanguineo());
            stmt.setDate(4, Date.valueOf(doador.getDataNascimento()));
            stmt.setString(5, doador.getSenha()); // Senha já deve ser um hash!
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao salvar doador: " + e.getMessage());
        }
    }

    // Método 2: Atualizar doador
    public void atualizar(Doador doador) {
        String sql = "UPDATE doadores SET nome = ?, cpf = ?, tipo_sanguineo = ?, data_nascimento = ?, senha = ? WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, doador.getNome());
            stmt.setString(2, doador.getCpf());
            stmt.setString(3, doador.getTipoSanguineo());
            stmt.setDate(4, Date.valueOf(doador.getDataNascimento()));
            stmt.setString(5, doador.getSenha());
            stmt.setInt(6, doador.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar doador: " + e.getMessage());
        }
    }

    // Método 3: Excluir doador
    public void excluir(int id) {
        String sql = "DELETE FROM doadores WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao excluir doador: " + e.getMessage());
        }
    }

    // Método 4: Buscar por ID
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
            System.err.println("Erro ao buscar doador: " + e.getMessage());
        }
        return null;
    }

    // Método 5: Listar todos
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
            System.err.println("Erro ao listar doadores: " + e.getMessage());
        }
        return doadores;
    }

    // Método 6: Autenticar (login)
    public Doador autenticar(String cpf, String senha) {
        String sql = "SELECT * FROM doadores WHERE cpf = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Doador doador = mapearDoador(rs);
                if (BCrypt.checkpw(senha, doador.getSenha())) {
                    return doador;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
        }
        return null;
    }

    // Método 7: Verificar CPF existente
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
            System.err.println("Erro ao verificar CPF: " + e.getMessage());
        }
        return false;
    }

    // Método 8: Buscar por tipo sanguíneo
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
            System.err.println("Erro ao buscar por tipo sanguíneo: " + e.getMessage());
        }
        return doadores;
    }

    // Método auxiliar: Converter ResultSet em Doador
    private Doador mapearDoador(ResultSet rs) throws SQLException {
        Doador doador = new Doador();
        doador.setId(rs.getInt("id"));
        doador.setNome(rs.getString("nome"));
        doador.setCpf(rs.getString("cpf"));
        doador.setTipoSanguineo(rs.getString("tipo_sanguineo"));
        doador.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        doador.setSenha(rs.getString("senha"));
        return doador;
    }
}
