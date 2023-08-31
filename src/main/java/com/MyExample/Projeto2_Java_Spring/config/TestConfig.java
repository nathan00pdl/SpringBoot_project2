package com.MyExample.Projeto2_Java_Spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.MyExample.Projeto2_Java_Spring.entities.Order;
import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.entities.enums.OrderStatus;
import com.MyExample.Projeto2_Java_Spring.repositories.OrderRepository;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;

@Configuration
@Profile("test")  //Indica que essa classe é uma classe de configuração específica para o perfil de 'test' (configurado no arquivo 'application.properties')
public class TestConfig implements CommandLineRunner{
	
	//Declarando de dependências
	
	@Autowired  //Resolve a dependência e associa uma instância desse objeto ('userRepository') à classe 'TesteConfig'
	private UserRepository userRepository;  

	
	@Autowired
	private OrderRepository orderRepository;
	
	
	//Declarando métodos
	
	@Override
	public void run(String... args) throws Exception {
		
		//Instanciando usuários que serão salvos no banco de dados H2
		User u1 = new User(null, "João Pedro", "jp.silva@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "João fauser", "fauser.bragion@gmail.com", "977777777", "123456");
		//OBS: 'id' nulo pois será gerado de forma automática assim que esses dados forem inseridos no banco de dados
	
		//Instanciando pedidos que serão salvos no banco de dados H2
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1); 
		
		//Salvando usuários e pedidos no banco de dados H2
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
