package com.MyExample.Projeto2_Java_Spring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto2_Java_Spring.entities.User;

//Classe 'UserResource' é responsável por forneceer recursos web (implementados por controladores rest) 
//correspondentes para a classe 'User'

@RestController 
@RequestMapping(value = "/users")
public class UserResource { 

	//Declarando 'endpoint' responsável por acessar os usuários
	
	@GetMapping //Indica que o método responde pela requisição do tipo 'GET' do protocolo http  
	public ResponseEntity<User> findall(){
		User u = new User(1L, "oi", "oi@gmail", "415651", "12345");
		return ResponseEntity.ok().body(u);
	}
}
