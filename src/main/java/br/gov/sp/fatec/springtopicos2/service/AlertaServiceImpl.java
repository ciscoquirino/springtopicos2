package br.gov.sp.fatec.springtopicos2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.springtopicos2.entity.Alerta;
import br.gov.sp.fatec.springtopicos2.repository.AlertaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlertaServiceImpl implements AlertaService{

    private AlertaRepository repo;

    public AlertaServiceImpl(AlertaRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Alerta novoAlerta(Alerta alerta) {
        if(alerta.getData_hora_geracao() == null){
            alerta.setData_hora_geracao(LocalDateTime.now());
        };
        if(alerta.getNivel() == null ){
            alerta.setNivel(5);
        };
        return repo.save(alerta);
    }

    @Override
    public List<Alerta> todosAlertas() {
        List<Alerta> alertas = new ArrayList<Alerta>();
            for(Alerta alerta: repo.findAll()) {
                alertas.add(alerta);
            }
            return alertas;
    }

    @Override
    public List<Alerta> alertasPorDataNivel(LocalDateTime data_hora_geracao, Integer nivel) {
        return repo.buscarPorDataNivel(data_hora_geracao, nivel);
    }
    

}
