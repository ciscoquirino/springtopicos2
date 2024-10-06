package br.gov.sp.fatec.springtopicos2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springtopicos2.entity.Trabalho;
import br.gov.sp.fatec.springtopicos2.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;

    @GetMapping(value = "/listar")
    public List<Trabalho> todosTrabalhos() {
        return service.todosTrabalhos();
    }

    @PostMapping
    public Trabalho novoTrabalho(@RequestBody Trabalho trabalho) {
        return service.novoTrabalho(trabalho);
    }

    @GetMapping(value = "/busca")
    public List<Trabalho> trabalhosPorNomeNota(@RequestBody Trabalho trabalho) {
        String tit = "%" + trabalho.getTitulo() + "%";
        return service.trabalhosPorNomeNota(tit, trabalho.getNota());
    }

}
