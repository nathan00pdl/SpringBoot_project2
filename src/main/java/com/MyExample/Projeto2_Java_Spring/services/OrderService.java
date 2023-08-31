package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.Order;
import com.MyExample.Projeto2_Java_Spring.repositories.OrderRepository;

@Service
public class OrderService {

	//Declarando "Injeção de dependência"
	
	@Autowired 
	private OrderRepository repository;
	
	
	//Declarando endpoints
	
	//Retornando todos os pedidos do banco de dados
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	//Retornando pedidos pelo id
	public Order FindById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
