package com.mycompany.projeto.ods.model;

public class Hemocentro {
    private int id;
    private String nome;
    private String endereco;
    private int capacidadeDiaria;
    
    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public int getCapacidadeDiaria() { return capacidadeDiaria; }
    public void setCapacidadeDiaria(int capacidadeDiaria) { this.capacidadeDiaria = capacidadeDiaria; }

    @Override
    public String toString() {
        return nome; // para exibir no JComboBox
    }
}
