package com.andre.portfolio.controller;

import com.andre.portfolio.domain.Visitante;
import com.andre.portfolio.dto.NovoVisitante;
import com.andre.portfolio.respositories.VisitanteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("visitante")
public class VisitanteController {

    private VisitanteRepository repository;

    @GetMapping("formulario")
    public String formulario(NovoVisitante requisicao){
        return "visitante/formulario";
    }

    @PostMapping("novo")
    public String novoVisitante(NovoVisitante requisicao) {
        if (requisicao.getNome() == null || requisicao.getEmail() == null) {
            return "visitante/formulario";
        }

        Visitante visitante = requisicao.toVisitante();
        repository.save(visitante);

        return "redirect:/portfolio";
    }


}
