package com.andre.portfolio.service;

import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;

import java.util.List;
import java.util.Optional;

public interface VisitanteService {

    Optional<Visitante> findById(Long id);
    List<Visitante> findAll();
    Visitante create(VisitanteDto visitanteDto);
    void createComentario(Visitante visitante, String comentario);
    void delete(Visitante comentario);

}
