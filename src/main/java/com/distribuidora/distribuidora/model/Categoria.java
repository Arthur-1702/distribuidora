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

}