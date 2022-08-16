package com.daniel.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.bookstore.domain.Livro;
import com.daniel.bookstore.repositories.LivroRepository;
import com.daniel.bookstore.services.exeptions.ObjectNotFoundExeption;

@Service
public class LivroService {
	
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption("objeto nao encontrado" + id + "tipo: "+ Livro.class.getName()));
	}
	public List<Livro> findAll(Integer id_cat) {
		categoriaservice.findByID(id_cat);
		return repository.findAllByCaegoria(id_cat);
	}
}
