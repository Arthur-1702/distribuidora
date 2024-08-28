package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBCATEGORIA")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODCATEGORIA")
	private Integer codCategoria;

	@Column(name = "NOMECATEGORIA", nullable = false, length = 40)
	private String nomeCategoria;

	//Faça os construtores

	public Categoria() {
	}

	public Categoria(Integer codCategoria, String nomeCategoria) {
		this.codCategoria = codCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	//Faça os getters e setters

	public Integer getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}