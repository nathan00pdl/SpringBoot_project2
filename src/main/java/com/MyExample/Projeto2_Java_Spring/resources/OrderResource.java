package com.MyExample.Projeto2_Java_Spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto2_Java_Spring.entities.Order;
import com.MyExample.Projeto2_Java_Spring.services.OrderService;

@RestController 
@RequestMapping(value = "/orders")
public class OrderResource { 

	//Declarando "Injeção de dependência"
	
	@Autowired  
	private OrderService service;
	
	
	//Declarando de endpoints:
	
	//Acessando os pedidos
	@GetMapping //Indica que o método responde pela requisição do tipo 'GET' do protocolo http  
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Retornando pedidos pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.FindById(id);
		 return ResponseEntity.ok().body(obj);
	}
	
}
