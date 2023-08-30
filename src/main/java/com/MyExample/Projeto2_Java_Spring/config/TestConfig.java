package com.MyExample.Projeto2_Java_Spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;

@Configuration
@Profile("test")  //Indica que essa classe é uma classe de configuração específica para o perfil de 'test' (configurado no arquivo 'application.properties')
public class TestConfig implements CommandLineRunner{
	
	@Autowired  //Resolve a dependência e associa uma instância desse objeto ('userRepository') à classe 'TesteConfig'
	private UserRepository userRepository;  //Declaração de dependência

	@Override
	public void run(String... args) throws Exception {
		
		//Instanciando usuários que serão salvos no banco de dados H2
		User u1 = new User(null, "João Pedro", "jp.silva@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "João fauser", "fauser.bragion@gmail.com", "977777777", "123456");
		//OBS: 'id' nulo pois será gerado de forma automática assim que esses dados forem inseridos no banco de dados
	
		//Salvando usuários no banco de dados H2
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
