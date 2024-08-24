package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "marca")
	private String marca;

	@Column(name = "tipoBebida")
	private boolean tipoBebida;

    @Column(name = "volume")
    private double volume;

    @Column(name = "embalagem")
    private String embalagem;

    @Column(name = "preco")
    private double preco;

}