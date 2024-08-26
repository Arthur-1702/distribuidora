package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TBCLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODCLIENTE")
    private Integer codCliente;

    @Column(name = "NOMECLIENTE", nullable = false, length = 40)
    private String nomeCliente;

    @Column(name = "CGCENT", nullable = false, length = 14)
    private String cgcEnt; // Pode ser usado tanto para CNPJ quanto para CPF

    @Column(name = "RAMOATIVIDADE", nullable = false, length = 20)
    private String ramoAtividade;

    @Column(name = "ENDERECOCOM", nullable = false, length = 50)
    private String enderecoComercial;

    @Column(name = "COMPLEMENTOCOM", nullable = false, length = 20)
    private String complementoComercial;

    @Column(name = "BAIRROCOM", nullable = false, length = 20)
    private String bairroComercial;

    @Column(name = "CIDADECOM", nullable = false, length = 20)
    private String cidadeComercial;

    @Column(name = "UFCOM", nullable = false, length = 2)
    private String ufComercial;

    @Column(name = "CEPCOM", nullable = false, length = 8)
    private String cepComercial;

    @Column(name = "ENDERECOENT", length = 50)
    private String enderecoEntrega;

    @Column(name = "COMPLEMENTOENT", length = 20)
    private String complementoEntrega;

    @Column(name = "BAIRROENT", length = 20)
    private String bairroEntrega;

    @Column(name = "CIDADEENT", length = 20)
    private String cidadeEntrega;

    @Column(name = "UFENT", length = 2)
    private String ufEntrega;

    @Column(name = "CEPENT", length = 8)
    private String cepEntrega;

    @Column(name = "ENDERECOCOB", length = 50)
    private String enderecoCobranca;

    @Column(name = "COMPLEMENTOCOB", length = 20)
    private String complementoCobranca;

    @Column(name = "BAIRROCOB", length = 20)
    private String bairroCobranca;

    @Column(name = "CIDADECOB", length = 20)
    private String cidadeCobranca;

    @Column(name = "UFCOB", length = 2)
    private String ufCobranca;

    @Column(name = "CEPCOB", length = 8)
    private String cepCobranca;

    @Column(name = "TELEFONE", nullable = false, length = 11)
    private String telefone;

    @Column(name = "EMAIL", nullable = false, length = 20)
    private String email;

    @Column(name = "CONTATOCARGO1", length = 20)
    private String contatoCargo1;

    @Column(name = "CONTATONOME1", length = 20)
    private String contatoNome1;

    @Column(name = "CONTATOCPF1", length = 11)
    private String contatoCpf1;

    @Column(name = "CONTATOCARGO2", length = 20)
    private String contatoCargo2;

    @Column(name = "CONTATONOME2", length = 20)
    private String contatoNome2;

    @Column(name = "CONTATOCPF2", length = 11)
    private String contatoCpf2;

    @Column(name = "CONTATOCARGO3", length = 20)
    private String contatoCargo3;

    @Column(name = "CONTATONOME3", length = 20)
    private String contatoNome3;

    @Column(name = "CONTATOCPF3", length = 11)
    private String contatoCpf3;

    @ManyToOne
    @JoinColumn(name = "PRAZOPAGAMENTO", nullable = false)
    private PlanoPagamento planoPagamento;

    @Column(name = "DTCADASTRO", nullable = false)
    private LocalDate dtCadastro;

    @PrePersist
    protected void onCreate() {
        this.dtCadastro = LocalDate.now();
    }

}