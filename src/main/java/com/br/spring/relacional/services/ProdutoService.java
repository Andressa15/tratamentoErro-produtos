package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	
	public String salvarProduto(Produto produto) {
		
		produtoRepository.save(produto);
		
		return "Produto Salvado com Sucesso";
	}
	
	public Iterable<Produto> buscarTodosPrdutos(){
		return produtoRepository.findAll();
	}
	
	public void deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto buscarProduto(Integer id ){
		return produtoRepository.findById(id).get();
	}
}
