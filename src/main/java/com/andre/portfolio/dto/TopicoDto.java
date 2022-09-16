package com.andre.portfolio.dto;

import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoDto {

    private String id;
    private String comentario;

    public Topico toTopico() {
        Topico topico = new Topico();
        topico.setComentario(comentario);
        return topico;
    }

}
