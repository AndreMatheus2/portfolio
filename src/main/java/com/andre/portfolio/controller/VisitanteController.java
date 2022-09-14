package com.andre.portfolio.controller;


import com.andre.portfolio.dto.VisitanteDto;

import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;
import com.andre.portfolio.service.VisitanteService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("visitante")
public class VisitanteController {


    @Autowired
    private VisitanteService visitanteService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public String formulario(){
        return "visitante/formulario";
    }

    @PostMapping("novo/portfolio")
    public String novo(VisitanteDto visitanteDto){
        if(visitanteDto.getNome().isEmpty() || visitanteDto.getEmail().isEmpty()) {
            return "visitante/formulario";
        }

        //Visitante visitante = visitanteDto.toVisitante();
        //visitanteRepository.save(visitante);

        visitanteService.create(visitanteDto);
        visitanteService.findAll();

        return "portfolio";
    }

    @PostMapping("visitante/comentario")
    public void comentar(Visitante visitante, String comentario){
         visitanteService.createComentario(visitante, comentario);
    }



    @DeleteMapping("visitante/comentario")
    public void excluir(){
    }


}
