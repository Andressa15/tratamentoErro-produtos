package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginserv;

	@GetMapping
	public ResponseEntity exibirLogin() {
		if(loginserv.quantidadeDeLogins() > 0) {
			return ResponseEntity.ok(loginserv.pegarLogin());
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pegarLoginPeloID(@PathVariable int id) {
		try {
			Login login = loginserv.pegarLoginPeloID(id);
			return ResponseEntity.ok(login);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> criarLogin(@Valid @RequestBody Login login) {
		try {
			loginserv.cadastrarLogin(login);
			return ResponseEntity.status(HttpStatus.CREATED).body(login);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

//	@PostMapping("/cadastro/login")
//	public ModelAndView cadastrarLogin(@Valid Usuario user, BindingResult bindingUser, @Valid Login login,
//			BindingResult bindingLogin) {
//		ModelAndView mv = new ModelAndView("cadastro.html");
//		if (bindingUser.hasErrors() || bindingLogin.hasErrors()) {
//			List<String> msgs = new ArrayList<String>();
//			for (ObjectError objerro : bindingUser.getAllErrors()) {
//				msgs.add(objerro.getDefaultMessage());
//			}
//			for (ObjectError objerro : bindingLogin.getAllErrors()) {
//				msgs.add(objerro.getDefaultMessage());
//			}
//			mv.addObject("msgs", msgs);
//		} else {
//			mv.addObject("msgs", loginserv.cadastrarLogin(user, login));
//
//		}
//
//		return mv;
//	}
	
	@PostMapping("/sair")
	public ModelAndView sair(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("redirect:/login");
		session.removeAttribute("usuario");
		return modelAndView;
	}
}
