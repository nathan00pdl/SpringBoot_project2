package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.Product;
import com.MyExample.Projeto2_Java_Spring.repositories.ProductRepository;

@Service
public class ProductService {

	//Declarando "Injeção de dependência"
	
	@Autowired   
	private ProductRepository repository;
	
	
	//Declarando endpoints
	
	//Retornando todos os usuários do banco de dados
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	//Retornando usuários pelo id
	public Product FindById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
