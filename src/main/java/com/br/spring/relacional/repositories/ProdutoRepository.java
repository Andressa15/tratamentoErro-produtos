package com.br.spring.relacional.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.spring.relacional.models.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
