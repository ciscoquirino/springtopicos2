package br.gov.sp.fatec.springtopicos2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springtopicos2.entity.Alerta;
import br.gov.sp.fatec.springtopicos2.service.AlertaService;


@RestController
@RequestMapping(value = "/alerta")
@CrossOrigin
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping(value = "/listar")
    public List<Alerta> todosAlertas() {
        return service.todosAlertas();
    }

    @PostMapping
    public Alerta novoAlerta(@RequestBody Alerta alerta) {
        return service.novoAlerta(alerta);
    }

    @GetMapping(value = "/consulta")
    public List<Alerta> alertasPorDataNivel(@RequestBody Alerta alerta) {
        
        return service.alertasPorDataNivel(alerta.getData_hora_geracao(), alerta.getNivel());
    }


}
