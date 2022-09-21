package com.andre.portfolio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    public Topico() {
    }

    public Topico(String email) {
        this.email = email;
    }
}
