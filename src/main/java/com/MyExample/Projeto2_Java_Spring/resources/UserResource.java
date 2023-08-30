package com.MyExample.Projeto2_Java_Spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.services.UserService;

//Classe 'UserResource' é responsável por forneceer recursos web (implementados por controladores rest) 
//correspondentes para a classe 'User'

@RestController 
@RequestMapping(value = "/users")
public class UserResource { 

	//Declarando de dependência:
	
	@Autowired  //Resolve a dependência e associa uma instância desse objeto ('userRepository') à classe 'userService'
	private UserService service;
	
	
	//Declarando de endpoints:
	
	//Acessando os usuários
	@GetMapping //Indica que o método responde pela requisição do tipo 'GET' do protocolo http  
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Retornando usuários pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.FindById(id);
		 return ResponseEntity.ok().body(obj);
	}
	
}
