package com.mycompany.projeto.ods.model;

import java.time.LocalDate;

public class Doador {
    private int id;
    private String nome;
    private String cpf;
    private String tipoSanguineo;
    private LocalDate dataNascimento; 
    private String senha;

    // Getters e Setters (métodos de acesso)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public String getTipoSanguineo() { return tipoSanguineo; }
    public void setTipoSanguineo(String tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento;}
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}