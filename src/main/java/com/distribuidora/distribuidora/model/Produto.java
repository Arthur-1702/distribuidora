package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

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

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;
}