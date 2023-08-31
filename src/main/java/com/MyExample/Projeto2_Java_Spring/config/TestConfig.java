package com.MyExample.Projeto2_Java_Spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.MyExample.Projeto2_Java_Spring.entities.Category;
import com.MyExample.Projeto2_Java_Spring.entities.Order;
import com.MyExample.Projeto2_Java_Spring.entities.Product;
import com.MyExample.Projeto2_Java_Spring.entities.User;
import com.MyExample.Projeto2_Java_Spring.entities.enums.OrderStatus;
import com.MyExample.Projeto2_Java_Spring.repositories.CategoryRepository;
import com.MyExample.Projeto2_Java_Spring.repositories.OrderRepository;
import com.MyExample.Projeto2_Java_Spring.repositories.ProductRepository;
import com.MyExample.Projeto2_Java_Spring.repositories.UserRepository;

@Configuration
@Profile("test") // Indica que essa classe é uma classe de configuração específica para o perfil
					// de 'test' (configurado no arquivo 'application.properties')
public class TestConfig implements CommandLineRunner {

	// Declarando "Injeções de dependências"

	@Autowired // Resolve a dependência e associa uma instância desse objeto ('userRepository')
				// à classe 'TesteConfig'
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	// Declarando métodos

	@Override
	public void run(String... args) throws Exception {
		//Instanciando categorias que serão salvas no banco de dados H2
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		//Instanciando produtos que serão salvos no banco de dados H2
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		
		//Salvando categorias e produtos no banco de dados H2
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		//Instanciando usuários que serão salvos no banco de dados H2
		User u1 = new User(null, "João Pedro", "jp.silva@gmail.com", "988888888", "123456");
		User u2 = new User(null, "João fauser", "fauser.bragion@gmail.com", "977777777", "123456");
		//OBS: 'id' nulo pois será gerado de forma automática assim que esses dados
		//forem inseridos no banco de dados

		//Instanciando pedidos que serão salvos no banco de dados H2
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

		// Salvando usuários e pedidos no banco de dados H2
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
