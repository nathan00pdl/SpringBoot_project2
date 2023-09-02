package com.MyExample.Projeto2_Java_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyExample.Projeto2_Java_Spring.entities.OrderItem;

//Interface responsável por instanciar objetos do tipo 'repository'

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	//OBS: O framework Spring já possui uma implementação padrão para essa interface.
}
