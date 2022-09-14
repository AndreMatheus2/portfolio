package com.andre.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    @OneToOne
    private Visitante visitante;

    public Topico() {
    }

    public Topico(String comentario, Visitante visitante) {
        this.comentario = comentario;
        this.visitante = visitante;
    }
}
