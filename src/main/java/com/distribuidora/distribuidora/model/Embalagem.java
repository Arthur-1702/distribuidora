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

    //Faça os construtores

    public Embalagem() {
    }

    public Embalagem(Integer codEmbalagem, String nome, Integer qtd) {
        this.codEmbalagem = codEmbalagem;
        this.nome = nome;
        this.qtd = qtd;
    }

    //Faça os getters e setters

    public Integer getCodEmbalagem() {
        return codEmbalagem;
    }

    public void setCodEmbalagem(Integer codEmbalagem) {
        this.codEmbalagem = codEmbalagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

}
