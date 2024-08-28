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

	//Faça os construtores
	public PlanoPagamento() {
	}

	public PlanoPagamento(Integer codPlanoPag, String descricao) {
		this.codPlanoPag = codPlanoPag;
		this.descricao = descricao;
	}

	//Faça os getters e setters

	public Integer getCodPlanoPag() {
		return codPlanoPag;
	}

	public void setCodPlanoPag(Integer codPlanoPag) {
		this.codPlanoPag = codPlanoPag;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}