package br.gov.sp.fatec.springtopicos2.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.springtopicos2.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
