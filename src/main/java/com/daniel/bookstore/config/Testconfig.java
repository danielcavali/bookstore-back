package com.daniel.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.bookstore.services.DBService;

@Configuration
@Profile("test")
public class Testconfig {

	@Autowired
	private DBService dbService;

    @Bean
    public void instanciabancodedados() {
        this.dbService.instanciabancodedados();
    }
}
