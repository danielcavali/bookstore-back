package com.daniel.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.daniel.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "campo nome é obrigatório")
	@Length (min = 3, max = 100, message = "o campo nome deve ter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "campo descriçao é obrigatório")
	@Length (min = 3, max = 200, message = "o campo descriçao deve ter entre 3 e 200 caracteres")
	private String descriçao;
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descriçao = obj.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescriçao() {
		return descriçao;
	}
	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	
	

}
