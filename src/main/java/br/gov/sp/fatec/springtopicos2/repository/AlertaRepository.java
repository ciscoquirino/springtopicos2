package br.gov.sp.fatec.springtopicos2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.springtopicos2.entity.Alerta;

public interface AlertaRepository extends CrudRepository<Alerta, Long>{

    @Query("SELECT a FROM Alerta a WHERE a.data_hora_geracao > :data_hora_geracao AND a.nivel < :nivel")
    public List<Alerta> buscarPorDataNivel(LocalDateTime data_hora_geracao, Integer nivel);

}
