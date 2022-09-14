package com.andre.portfolio.service;


import com.andre.portfolio.controller.VisitanteController;
import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.exceptions.DataIntegratyViolationException;
import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;
import com.andre.portfolio.respository.TopicoRepository;
import com.andre.portfolio.respository.VisitanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteServiceImpl implements VisitanteService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private VisitanteRepository visitanteRepository;
    @Autowired
    private VisitanteController visitanteController;
    @Autowired
    private ModelMapper mapper;

    public List<Visitante> findAll() {
        return visitanteRepository.findAll();
    }

    public void findByEmail(VisitanteDto visitanteDto) {
        Optional<Visitante> visitante = visitanteRepository.findByEmail(visitanteDto.getEmail());
        if(visitante.isPresent() && !visitante.get().getId().equals(visitanteDto.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
    public List<Visitante> listar() {
        List<Visitante> visitantes = visitanteRepository.findAll();
        for (Visitante visitante : visitantes) {
            visitante.getNome();
            visitante.getTopico();
        }
        return visitantes;
    }
    @Override
    public Optional<Visitante> findById(Long id) {
        Optional<Visitante> obj = visitanteRepository.findById(id);
        return obj;
    }

    @Override
    public Visitante create(VisitanteDto visitanteDto) {
        findByEmail(visitanteDto);
        return visitanteRepository.save(mapper.map(visitanteDto, Visitante.class));
    }

    public void findByComentario(String comentario) {
        topicoRepository.findByComentario(comentario);
    }
    @Override
    public void createComentario(Visitante visitante, String comentario) {
        findByComentario(comentario);
        visitante.getTopico().setComentario(comentario);
        topicoRepository.save(mapper.map(comentario, Topico.class));
    }

    @Override
    public void delete(Visitante comentario) {
        visitanteRepository.delete(comentario);
    }

}
