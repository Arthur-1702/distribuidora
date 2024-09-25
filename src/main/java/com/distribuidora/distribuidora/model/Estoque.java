package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBESTOQUE")
public class Estoque {

	@Id
    @Column(name = "CODPRODUTO")
    private Long id; // Define um ID separado para Estoque, que será o mesmo de Produto

    @OneToOne
    @MapsId // Indica que o ID de Estoque é o mesmo de Produto
    @JoinColumn(name = "CODPRODUTO", nullable = false)
    private Produto produto;

    @Column(name = "QTESTOQUEGERENCIAL", nullable = false)
    private Integer qtEstoqueGerencial;

    @Column(name = "QTTRANSITO", nullable = false)
    private Integer qtTransito;

    @Column(name = "QTDISPONIVEL", nullable = false)
    private Integer qtDisponivel;

    @Column(name = "QTRESERVADA", nullable = false)
    private Integer qtReservada;

    @Column(name = "DTVALIDADE")
    private LocalDate dtValidade;

    @Column(name = "DTULTENTRADA")
    private LocalDate dtUltEntrada;

    @Column(name = "GIROPRODUTO")
    private Double giroProduto;

	// Construtores
	public Estoque() {
	}

	public Estoque(Produto produto, Integer qtEstoqueGerencial, Integer qtTransito, Integer qtDisponivel,
			Integer qtReservada, LocalDate dtValidade, LocalDate dtUltEntrada, Double giroProduto) {
		this.produto = produto;
		this.qtEstoqueGerencial = qtEstoqueGerencial;
		this.qtTransito = qtTransito;
		this.qtDisponivel = qtDisponivel;
		this.qtReservada = qtReservada;
		this.dtValidade = dtValidade;
		this.dtUltEntrada = dtUltEntrada;
		this.giroProduto = giroProduto;
	}

	// Getters e Setters

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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