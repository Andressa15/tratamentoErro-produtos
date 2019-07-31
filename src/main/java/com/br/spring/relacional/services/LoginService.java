package com.br.spring.relacional.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.exceptions.LoginNaoEncontradoException;
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
	
	public void upadate(int id, Login login) {
		Optional<Login> optionalLogin = loginRepo.findById(id);
		if(!optionalLogin.isPresent()) {
			throw new LoginNaoEncontradoException("Não há login com esse id");
		}
		login.setId(id);
		loginRepo.save(login);
	}
	
	public void apagarLogin(int id) {
		loginRepo.deleteById(id);
	}
	
	public Login buscarPorApelidoESenha(Login login) {
		return loginRepo.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}
}
