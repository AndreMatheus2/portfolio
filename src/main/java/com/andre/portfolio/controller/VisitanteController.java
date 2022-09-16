package com.andre.portfolio.controller;

import com.andre.portfolio.dto.TopicoDto;
import com.andre.portfolio.dto.VisitanteDto;
import com.andre.portfolio.model.Topico;
import com.andre.portfolio.model.Visitante;
import com.andre.portfolio.respository.TopicoRepository;
import com.andre.portfolio.respository.VisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String novo(VisitanteDto visitanteDto, TopicoDto topicoDto){
        if(visitanteDto.getNome().isEmpty() || visitanteDto.getEmail().isEmpty()) {
            return "visitante/formulario";
        }

        Visitante visitante = visitanteDto.toVisitante();
        try {
            Topico topico = topicoDto.toTopico();
            visitante.setTopico(topico);
        }catch (NullPointerException e){
            System.out.print("Comentario nulo");
        }finally {
            visitanteRepository.save(visitante);
            return "portfolio";
        }

    }

    @PostMapping("comentario")
    public String comentar(@Valid TopicoDto topicoDto, BindingResult result){
        String comentario = topicoDto.getComentario();
        Topico topico = topicoDto.toTopico();
        topico.setComentario(comentario);
        topicoRepository.save(topico);
        return "lista";
    }



  //  @DeleteMapping("visitante/comentario")




}
