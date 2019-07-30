package com.br.spring.relacional.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.spring.relacional.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
