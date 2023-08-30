package com.MyExample.Projeto2_Java_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyExample.Projeto2_Java_Spring.entities.User;

//Interface responsável por instanciar objetos do tipo 'repository' (esses objetos terão funcionalidades direcionadas para os usuários 'User')

public interface UserRepository extends JpaRepository<User, Long>{

	//OBS: O framework Spring já possui uma implementação padrão para essa interface.
}
