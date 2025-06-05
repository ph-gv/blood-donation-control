package com.mycompany.projeto.ods.dao;

import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.util.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HemocentroDAO {
    public List<Hemocentro> listarTodos() {
        List<Hemocentro> lista = new ArrayList<>();
        String sql = "SELECT * FROM locais_coleta"; // ou 'hemocentros', de acordo com seu esquema
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Hemocentro h = new Hemocentro();
                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setEndereco(rs.getString("endereco"));
                h.setCapacidadeDiaria(rs.getInt("capacidade_diaria"));
                lista.add(h);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar hemocentros: " + e.getMessage());
        }
        return lista;
    }

    public Hemocentro buscarPorId(int id) {
        String sql = "SELECT * FROM locais_coleta WHERE id = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Hemocentro h = new Hemocentro();
                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setEndereco(rs.getString("endereco"));
                h.setCapacidadeDiaria(rs.getInt("capacidade_diaria"));
                return h;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar hemocentro: " + e.getMessage());
        }
        return null;
    }

    /**
     * Busca um Hemocentro pelo nome exato.
     * Retorna o objeto Hemocentro se encontrado, ou null caso contrário.
     */
    public Hemocentro buscarPorNome(String nome) {
        String sql = "SELECT * FROM locais_coleta WHERE nome = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Hemocentro h = new Hemocentro();
                h.setId(rs.getInt("id"));
                h.setNome(rs.getString("nome"));
                h.setEndereco(rs.getString("endereco"));
                h.setCapacidadeDiaria(rs.getInt("capacidade_diaria"));
                return h;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar hemocentro por nome: " + e.getMessage());
        }
        return null;
    }

    // Futuramente, podem-se adicionar métodos de inserir/atualizar/excluir
}