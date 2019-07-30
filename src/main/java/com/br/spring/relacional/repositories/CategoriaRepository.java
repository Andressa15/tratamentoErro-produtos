package com.br.spring.relacional.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.spring.relacional.models.Categoria;
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
