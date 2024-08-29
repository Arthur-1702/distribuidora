package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBESTOQUE")
public class Estoque {

	@Id
	@OneToOne
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

	@Column(name = "GIROPRODUTO", precision = 6, scale = 2)
	private Double giroProduto;


}