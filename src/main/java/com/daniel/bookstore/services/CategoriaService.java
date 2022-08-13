package com.daniel.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.daniel.bookstore.domain.Categoria;
import com.daniel.bookstore.dtos.CategoriaDTO;
import com.daniel.bookstore.repositories.CategoriaRepository;
import com.daniel.bookstore.services.exeptions.ObjectNotFoundExeption;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findByID(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"objeto nao encontrado id:" + id + ", tipo:" + Categoria.class.getName()));

	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria create(Integer id, CategoriaDTO objdto) {
		// TODO Auto-generated method stub
		
		Categoria obj = findByID(id);
		obj.setNome(objdto.getNome());
		obj.setDescricao(objdto.getDescriçao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		findByID(id);
		try {
			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityViolationException("objeto nao pode ser deletado");
		}
	}
}
