package com.MyExample.Projeto2_Java_Spring.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//OBS: A interface 'Serializable' é responsável por transformar os objetos (nesse caso a classe 'User') em uma 
//CADEIA DE BYTES. Dessa forma, os objetos são capazes de trafegar pela rede, serem salvos em arquivos e etc.

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id  //Indicação de que o atributo 'id' será uma primary key do banco de dados H2
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Esse atributo será autoincrementável no banco de dados H2
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//Declarando associações
	
	//Declaradando Construtores
	public User () {}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	
	//Declaradando métodos getters e setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	//Declaradando métodos Equals e HashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	//Declaradando métodos

}

