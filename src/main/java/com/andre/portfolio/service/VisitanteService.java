package com.andre.portfolio.service;

import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.exceptions.DataIntegratyViolationException;
import com.andre.portfolio.model.Visitante;
import com.andre.portfolio.respository.VisitanteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    public List<Visitante> findAll() {
        return repository.findAll();
    }

    public void findByEmail(VisitanteDto obj) {
        Optional<Visitante> visitante = visitanteRepository.findByEmail(obj.getEmail());
        if(visitante.isPresent() && !visitante.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    } public void findByComentario(VisitanteDto obj) {
        Optional<Visitante> visitante = visitanteRepository.findByComentario(obj.getComentario());

    }
    public List<Visitante> listar() {
        List<Visitante> visitantes = visitanteRepository.findAll();
        for (Visitante visitante : visitantes) {
            visitante.getNome();
            visitante.getComentario();
        }
        return visitantes;
    }

    public Visitante criar(Visitante visitante){

    }
}
