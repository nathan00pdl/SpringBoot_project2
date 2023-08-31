package com.MyExample.Projeto2_Java_Spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto2_Java_Spring.entities.Product;
import com.MyExample.Projeto2_Java_Spring.services.ProductService;

@RestController 
@RequestMapping(value = "/products")
public class ProductResource { 

	//Declarando "Injeção de dependência"
	
	@Autowired 
	private ProductService service;
	
	
	//Declarando de endpoints:
	
	//Acessando os usuários
	@GetMapping //Indica que o método responde pela requisição do tipo 'GET' do protocolo http  
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Retornando usuários pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.FindById(id);
		 return ResponseEntity.ok().body(obj);
	}
	
}
