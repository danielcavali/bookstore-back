package com.daniel.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class Devconfig {
	@Autowired
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public Boolean instanBaseDeDados() {
		
		if(strategy.equals("create")) {
			this.dbservice.instanciabancodedados();
			
		}
		
		return false;
	}

}
