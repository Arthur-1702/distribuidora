package com.distribuidora.distribuidora.dto;

import java.time.LocalDate;

public class EstoqueDTO {

    private Long produtoId;
    private Integer qtEstoqueGerencial;
    private Integer qtTransito;
    private Integer qtDisponivel;
    private Integer qtReservada;
    private LocalDate dtValidade;
    private LocalDate dtUltEntrada;
    private Double giroProduto;

    // Construtores
    public EstoqueDTO() {}

    public EstoqueDTO(Long produtoId, Integer qtEstoqueGerencial, Integer qtTransito, Integer qtDisponivel, Integer qtReservada, LocalDate dtValidade, LocalDate dtUltEntrada, Double giroProduto) {
        this.produtoId = produtoId;
        this.qtEstoqueGerencial = qtEstoqueGerencial;
        this.qtTransito = qtTransito;
        this.qtDisponivel = qtDisponivel;
        this.qtReservada = qtReservada;
        this.dtValidade = dtValidade;
        this.dtUltEntrada = dtUltEntrada;
        this.giroProduto = giroProduto;
    }

    // Getters e Setters
    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQtEstoqueGerencial() {
        return qtEstoqueGerencial;
    }

    public void setQtEstoqueGerencial(Integer qtEstoqueGerencial) {
        this.qtEstoqueGerencial = qtEstoqueGerencial;
    }

    public Integer getQtTransito() {
        return qtTransito;
    }

    public void setQtTransito(Integer qtTransito) {
        this.qtTransito = qtTransito;
    }

    public Integer getQtDisponivel() {
        return qtDisponivel;
    }

    public void setQtDisponivel(Integer qtDisponivel) {
        this.qtDisponivel = qtDisponivel;
    }

    public Integer getQtReservada() {
        return qtReservada;
    }

    public void setQtReservada(Integer qtReservada) {
        this.qtReservada = qtReservada;
    }

    public LocalDate getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(LocalDate dtValidade) {
        this.dtValidade = dtValidade;
    }

    public LocalDate getDtUltEntrada() {
        return dtUltEntrada;
    }

    public void setDtUltEntrada(LocalDate dtUltEntrada) {
        this.dtUltEntrada = dtUltEntrada;
    }

    public Double getGiroProduto() {
        return giroProduto;
    }

    public void setGiroProduto(Double giroProduto) {
        this.giroProduto = giroProduto;
    }
}
