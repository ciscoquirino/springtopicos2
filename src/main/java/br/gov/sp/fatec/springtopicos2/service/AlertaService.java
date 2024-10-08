package br.gov.sp.fatec.springtopicos2.service;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.sp.fatec.springtopicos2.entity.Alerta;

public interface AlertaService {

    public Alerta novoAlerta(Alerta alerta);

    public List<Alerta> todosAlertas();

    public List<Alerta> alertasPorDataNivel(LocalDateTime data_hora_geracao, Integer nivel);
}
