package com.daniel.bookstore.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.bookstore.domain.Categoria;
import com.daniel.bookstore.repositories.CategoriaRepository;
import com.daniel.bookstore.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {
	
	
	@Autowired
		private CategoriaRepository repository;
	
	public Categoria findByID(Integer id) {
		Optional<Categoria> obj=repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundExeption("objeto nao encontrado id:" + id +", tipo:" + Categoria.class.getName())); 
		
	}
}