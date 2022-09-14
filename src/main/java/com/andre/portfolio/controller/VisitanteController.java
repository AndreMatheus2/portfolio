package com.andre.portfolio.controller;


import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.model.Visitante;
import com.andre.portfolio.respository.VisitanteRepository;
import com.andre.portfolio.service.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("visitante")
public class VisitanteController {

    @Autowired
    private VisitanteRepository visitanteRepository;
    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public String formulario(){
        return "visitante/formulario";
    }

    @PostMapping("novo/portfolio")
    public String novo(VisitanteDto visitanteDto){
        if(visitanteDto.getNome().isEmpty() || visitanteDto.getEmail().isEmpty() || visitanteService.findByEmail()) {
            return "visitante/formulario";
        }

     //   Visitante visitante = visitanteDto.toVisitante();
      //  visitanteRepository.save(visitante);

        visitanteService.listar();

        return "portfolio";
    }


}
