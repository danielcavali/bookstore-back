package com.daniel.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.bookstore.domain.Categoria;
import com.daniel.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
		private CategoriaRepository repository;
	
	public Categoria findByID(Integer id) {
		Optional<Categoria> obj=repository.findById(id);
		return obj.orElse(null); 
		
	}
}
