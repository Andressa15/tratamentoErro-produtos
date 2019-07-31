package com.br.spring.relacional.helpers;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class DetalhesErro {
	
	private Date data;
	private int status;
	private String mensagem;
	private String origem;
	
	public DetalhesErro(String mensagem, String origem, HttpStatus status) {
		this.data = new Date();
		this.mensagem = mensagem;
		this.origem = origem;
		this.status = status.value();
	}

	public Date getData() {
		return data;
	}

	public int getStatus() {
		return status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getOrigem() {
		return origem;
	}	

}
