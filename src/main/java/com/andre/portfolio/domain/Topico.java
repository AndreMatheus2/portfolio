package com.andre.portfolio.domain;

import javax.persistence.*;

@Entity
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    @ManyToOne
    private Visitante autor;

    public Topico() {
    }

    public Topico(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Visitante getAutor() {
        return autor;
    }

    public void setAutor(Visitante autor) {
        this.autor = autor;
    }
}