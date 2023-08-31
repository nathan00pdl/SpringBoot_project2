package com.MyExample.Projeto2_Java_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyExample.Projeto2_Java_Spring.entities.Category;
import com.MyExample.Projeto2_Java_Spring.repositories.CategoryRepository;

@Service
public class CategoryService {

	//Declarando "Injeções de dependências"
	
	@Autowired   
	private CategoryRepository repository;
	
	
	//Declarando de endpoints:
	
	//Retornando todos as categorias do banco de dados
	public List<Category> findAll(){
		return repository.findAll(); 
	}
	
	//Retornando usuários pelo id
	public Category FindById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
