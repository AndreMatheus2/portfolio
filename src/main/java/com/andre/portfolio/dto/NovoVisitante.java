package com.andre.portfolio.dto;

import com.andre.portfolio.domain.Visitante;

public class NovoVisitante {


    private String nome;
    private String email;

    public NovoVisitante(Visitante visitante) {
        this.nome = visitante.getNome();
        this.email = visitante.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Visitante toVisitante() {
        Visitante visitante = new Visitante();
        visitante.setNome(nome);
        visitante.setEmail(email);
        return visitante;
    }
}
