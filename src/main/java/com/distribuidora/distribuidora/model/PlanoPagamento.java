package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TBPLANOPAG")
public class PlanoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODPLANOPAG")
	private Integer codPlanoPag;

	@Column(name = "DESCRICAO", length = 20)
	private String descricao;

}