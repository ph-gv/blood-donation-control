package com.mycompany.projeto.ods.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Doacao {
    private int idDoacao;
    private int idDoador;
    private int idLocalColeta;
    private LocalDate data;
    private LocalTime horario;
    private String status;

    public Doacao() {
        // Construtor vazio
    }

    public Doacao(int idDoacao, int idDoador, int idLocalColeta, LocalDate data, LocalTime horario, String status) {
        this.idDoacao = idDoacao;
        this.idDoador = idDoador;
        this.idLocalColeta = idLocalColeta;
        this.data = data;
        this.horario = horario;
        this.status = status;
    }

    public int getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(int idDoacao) {
        this.idDoacao = idDoacao;
    }

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public int getIdLocalColeta() {
        return idLocalColeta;
    }

    public void setIdLocalColeta(int idLocalColeta) {
        this.idLocalColeta = idLocalColeta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
