package com.br.spring.relacional.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.br.spring.relacional.exceptions.LoginNaoEncontradoException;
import com.br.spring.relacional.helpers.DetalhesErro;

@ControllerAdvice
@RestController
public class LoginControllerAdvice {

	@ExceptionHandler(LoginNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLoginNaoEncontrado(LoginNaoEncontradoException e, WebRequest requisiscao) {
		DetalhesErro detalhesErro = new DetalhesErro(e.getMessage(), requisiscao.getDescription(false), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest requisicao) {
		DetalhesErro detalhesErro = new DetalhesErro(e.getMessage(), requisicao.getDescription(false), HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(detalhesErro.getStatus()).body(detalhesErro);
	}
	
}
