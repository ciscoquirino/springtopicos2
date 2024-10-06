package br.gov.sp.fatec.springtopicos2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.springtopicos2.entity.Trabalho;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long> {

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE :titulo AND t.nota > :nota")
    public List<Trabalho> buscarPorNomeNota(String titulo, Integer nota);

}
