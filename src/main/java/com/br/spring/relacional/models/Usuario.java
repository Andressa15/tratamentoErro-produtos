package com.br.spring.relacional.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome não pode ficar em branco")
	@Size(min = 2, message = "Nome tem que ter no mínimo 2 letras")
	private String nome;
	@NotBlank(message = "Sobrenome não pode ficar em branco")
	@Size(min = 4, message = "Nome tem que ter no mínimo 4 letras")
	private String sobrenome;
	@NotBlank(message = "Email não pode ficar em branco")
	@Email(message = "E-mail invalido")
	private String email;
	
	@OneToOne(mappedBy = "usuario")
	private Login login;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("usuario")
	private List<Pedido> pedido;
	
	

	public Usuario() {
		
	}
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
