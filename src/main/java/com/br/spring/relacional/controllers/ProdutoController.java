package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.services.CategoriaService;
import com.br.spring.relacional.services.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/produtos")
	public ModelAndView exibirProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtoService.buscarTodosPrdutos());
		return modelAndView;
	}

	@GetMapping("/cadastrar/produtos")
	public ModelAndView exibirFormulario(HttpSession session) {
		if (session.getAttribute("usuario") != null) {
			ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
			modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
			return modelAndView;

		}else {
			ModelAndView modelAndView = new ModelAndView("redirect:/login");
			session.setAttribute("ultimoURL", "/cadastrar/produtos");
			return modelAndView;

		}

	}

	@PostMapping("/cadastrar/produtos")
	public ModelAndView cadastrarProduto(@Valid Produto produto, BindingResult bindingProduto) {
		ModelAndView modelAndView = new ModelAndView("cadastroProduto.html");
		modelAndView.addObject("categorias", categoriaService.buscarTodasCategorias());
		if (bindingProduto.hasErrors()) {
			List<String> mensagens = new ArrayList<String>();
			for (ObjectError erros : bindingProduto.getAllErrors()) {
				mensagens.add(erros.getDefaultMessage());
			}
			modelAndView.addObject("mensagens", mensagens);
		} else {
			modelAndView.addObject("mensagens", produtoService.salvarProduto(produto));
		}
		return modelAndView;
	}

	@GetMapping("/editar/produto/{id}")
	public ModelAndView exibirProduto(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("editarProduto.html");
		modelAndView.addObject("produto", produtoService.buscarProduto(id));
		return modelAndView;
	}

	@PostMapping("/editar/produto/{id}")
	public ModelAndView editarProduto(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("editarProduto.html");
		modelAndView.addObject("mensagem", produtoService.salvarProduto(produto));
		return modelAndView;
	}

}
