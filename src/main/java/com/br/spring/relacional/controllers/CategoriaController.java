package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.services.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/cadastrar/categoria")
	public ResponseEntity<?> exibirFormulario(@Valid @RequestBody Categoria categoria) {
		try {
			categoriaService.cadastrarCategoria(categoria);
			return ResponseEntity.status(HttpStatus.CREATED).body(categoria);	
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?>  categoriaId(@PathVariable int id) {
		try {
			categoriaService.buscarTodasCategorias();
			return ResponseEntity.ok(id);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}