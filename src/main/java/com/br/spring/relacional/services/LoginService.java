package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.repositories.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepo;
	
	public Long quantidadeDeLogins() {
		return loginRepo.count();
	}
	
	public Iterable<Login> pegarLogin() {
		return loginRepo.findAll();
	}
	
	public Login pegarLoginPeloID(int id) {
		return loginRepo.findById(id).get();
	}
	
	public void cadastrarLogin(Login login) {
		loginRepo.save(login);		
	}
	
	public void upadate(Login login) {
		loginRepo.save(login);
	}
	
	public Login buscarPorApelidoESenha(Login login) {
		return loginRepo.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}
}
