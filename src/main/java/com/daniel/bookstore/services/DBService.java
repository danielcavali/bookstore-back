package com.daniel.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.bookstore.domain.Categoria;
import com.daniel.bookstore.domain.Livro;
import com.daniel.bookstore.repositories.CategoriaRepository;
import com.daniel.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciabancodedados() {

		Categoria cat1 = new Categoria(null, "info", "livro ti");
		Categoria cat2 = new Categoria(null, "teste", "aleatorio");
		Categoria cat3 = new Categoria(null, "qualquer", "its hard");
		Categoria cat4 = new Categoria(null, "aleatoriamente", "aleatoriamente qualquer ");

		Livro l1 = new Livro(null, "hardware completo", "desconhecido", " descriçao aqui mas nao tem agora ", cat1);
		Livro l2 = new Livro(null, "livrao brabo", "desconhecido aleatorio"," descriçao aqui mas nao tem agora depois vejo ", cat2);
		Livro l3 = new Livro(null, "hardware completo sem o completo", "desconhecido perdido",
				" descriçao aqui mas nao tem agora ja era pra ter mas... ", cat1);
		Livro l4 = new Livro(null, "redes desconhecidas ", "bruno delgado ", " descriçao e algo importante ", cat3);
		Livro l5 = new Livro(null, "uma historia ", "o mundo ", " descriçao aqui mas nao tem agora ", cat4);

		cat1.getLivros().addAll(Arrays.asList(l1, l3));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l4));
		cat4.getLivros().addAll(Arrays.asList(l5));

		
		categoriaRepository.saveAll(Arrays.asList(cat1));

		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
