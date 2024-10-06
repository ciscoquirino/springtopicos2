package br.gov.sp.fatec.springtopicos2.service;

import java.util.List;

import br.gov.sp.fatec.springtopicos2.entity.Trabalho;

public interface TrabalhoService {

    public Trabalho novoTrabalho(Trabalho trabalho);

    public List<Trabalho> todosTrabalhos();

    public List<Trabalho> trabalhosPorNomeNota(String titulo, Integer nota);
}
