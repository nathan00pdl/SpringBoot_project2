package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;

@Service
public class UserService {

	//Declaração de dependências:
	
	@Autowired  //Resolve a dependência e associa uma instância desse objeto ('userRepository') à classe 'UserService' 
	private UserRepository repository;
	
	
	//Declaração de endpoints:
	
	//Retornando todos os usuários do banco de dados
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//Retornando usuários pelo id
	public User FindById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
