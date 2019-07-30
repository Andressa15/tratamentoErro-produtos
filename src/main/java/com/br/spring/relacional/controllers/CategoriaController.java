package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.services.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public ModelAndView exibirCategorias() {
		ModelAndView modelAndView = new ModelAndView("categorias.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
		return modelAndView;
	}
	
	@GetMapping("/cadastrar/categoria")
	public ModelAndView exibirFormulario() {
		ModelAndView modelAndView = new ModelAndView("cadastroCategoria.html");
		return modelAndView;
	}
	
	@PostMapping("/cadastrar/categoria")
	public ModelAndView cadastrarCategoria(@Valid Categoria categoria, BindingResult bindingCategoria) {
		ModelAndView modelAndView = new ModelAndView("cadastroCategoria.html");
		
		if(bindingCategoria.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for (ObjectError erro : bindingCategoria.getAllErrors()) {
				mensagens.add(erro.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
		}else {
			modelAndView.addObject("mensagens", categoriaService.cadastrarCategoria(categoria));
		}
		return modelAndView;
	}
}
