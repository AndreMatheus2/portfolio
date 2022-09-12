package com.andre.portfolio.dto;

import com.andre.portfolio.domain.Topico;

import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {

    private Long id;
    private String comentario;

    public TopicoDto(Topico topico) {
        this.id = topico.getId();
        this.comentario = topico.getComentario();
    }

    public static List<TopicoDto> converter(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

}