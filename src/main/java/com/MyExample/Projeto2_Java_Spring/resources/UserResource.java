package com.MyExample.Projeto2_Java_Spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.services.UserService;

//Classe 'UserResource' é responsável por forneceer recursos web (implementados por controladores rest) 
//correspondentes para a classe 'User'

@RestController 
@RequestMapping(value = "/users")
public class UserResource { 

	//Declarando "Injeção de dependência"

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
	
	//OBS: Os dois endpints acima utilizam 'GetMapping' pois possuem a funcionalide de RECUPERAR dados do banco de dados
	
	//Inserindo usuários no banco de dados H2
	@PostMapping
	public 	ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//OBS: O endpoint acima utiliza 'PostMapping' pois possui a funcionalide de INSERIR dados no banco de dados
}
