package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public String cadastrarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "Categoria cadastrada";
	}
	
	public Iterable<Categoria> buscarTodasCategorias(){
		return categoriaRepository.findAll();
	}
}
