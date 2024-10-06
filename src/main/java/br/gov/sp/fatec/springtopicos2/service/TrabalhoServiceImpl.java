package br.gov.sp.fatec.springtopicos2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springtopicos2.entity.Trabalho;
import br.gov.sp.fatec.springtopicos2.repository.TrabalhoRepository;

@Service
public class TrabalhoServiceImpl implements TrabalhoService{

    private TrabalhoRepository repo;

    public TrabalhoServiceImpl(TrabalhoRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho == null ||
                trabalho.getTitulo() == null ||
                trabalho.getGrupo() == null ||
                trabalho.getTitulo().isBlank() ||
                trabalho.getGrupo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Preencha o título e grupo corretamente!");
        }else if(trabalho.getData_hora_entrega() == null){
            trabalho.setData_hora_entrega(LocalDateTime.now());
        }
        return repo.save(trabalho);
    }

    @Override
    public List<Trabalho> todosTrabalhos() {
        List<Trabalho> trabalhos = new ArrayList<Trabalho>();
            for(Trabalho trabalho: repo.findAll()) {
                trabalhos.add(trabalho);
            }
            return trabalhos;
    }

    @Override
    public List<Trabalho> trabalhosPorNomeNota(String titulo, Integer nota) {
        return repo.buscarPorNomeNota(titulo, nota);
    }

}
