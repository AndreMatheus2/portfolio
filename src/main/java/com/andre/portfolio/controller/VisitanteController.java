package com.andre.portfolio.controller;

import com.andre.portfolio.dto.TopicoDto;
import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;
import org.springframework.security.core.context.SecurityContextHolder;
import com.andre.portfolio.respository.TopicoRepository;
import com.andre.portfolio.respository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("visitante")
public class VisitanteController {


    @Autowired
    private VisitanteRepository visitanteRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public String formulario(){
        return "visitante/formulario";
    }

    @PostMapping("novo/portfolio")
    public String novo(TopicoDto topicoDto){
        if(topicoDto.getEmail().isEmpty()) {
            return "visitante/formulario";
        }

        Topico topico = topicoDto.toTopico();
        topicoRepository.save(topico);
        return "portfolio";
    }

    @PostMapping("comentario")
    public String comentar(VisitanteDto visitanteDto, Model model){
       if(visitanteDto.getNome().isEmpty() || visitanteDto.getComentario().isEmpty()){
           return "portfolio";
       }
       Visitante visitante = visitanteDto.toVisitante();
       visitanteRepository.save(visitante);

       List<Visitante> visitantes = visitanteRepository.findAll();
       //List<Visitante> visitantes = Arrays.asList(visitante);
        model.addAttribute("visitantes", visitantes);

        return "lista";
    }

  //  @DeleteMapping("visitante/comentario")
}
