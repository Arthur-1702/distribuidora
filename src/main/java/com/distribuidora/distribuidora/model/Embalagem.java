package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBEMBALAGEM")
public class Embalagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODEMBALAGEM")
    private Integer codEmbalagem;

    @Column(name = "NOME", nullable = false, length = 40)
    private String nome;

    @Column(name = "QTD", nullable = false)
    private Integer qtd;

}
