package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "TBFORNECEDOR")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODFORNECEDOR")
    private Integer codFornecedor;

    @Column(name = "NOMEFORNECEDOR", nullable = false, length = 40)
    private String nomeFornecedor;

    @Column(name = "CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "ENDERECOCOM", nullable = false, length = 50)
    private String enderecoComercial;

    @Column(name = "COMPLEMENTOCOM", length = 20)
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

    @Column(name = "UFENT", nullable = false, length = 2)
    private String ufEntrega;

    @Column(name = "CEPENT", nullable = false, length = 8)
    private String cepEntrega;

    @Column(name = "ENDERECOCOB", length = 50)
    private String enderecoCobranca;

    @Column(name = "COMPLEMENTOCOB", length = 20)
    private String complementoCobranca;

    @Column(name = "BAIRROCOB", length = 20)
    private String bairroCobranca;

    @Column(name = "CIDADECOB", length = 20)
    private String cidadeCobranca;

    @Column(name = "UFCOB", nullable = false, length = 2)
    private String ufCobranca;

    @Column(name = "CEPCOB", nullable = false, length = 8)
    private String cepCobranca;

    @Column(name = "TELEFONE", nullable = false, length = 11)
    private String telefone;

    @Column(name = "EMAIL", nullable = false, length = 20)
    private String email;

    @ManyToOne
    @JoinColumn(name = "PRAZOPAGAMENTO", nullable = false)
    private PlanoPagamento planoPagamento;

    @ManyToOne
    @JoinColumn(name = "CODCLIENTE", nullable = false)
    private Cliente cliente;

    @Column(name = "DTCADASTRO", nullable = false)
    private LocalDate dtCadastro;

    @PrePersist
    protected void onCreate() {
        this.dtCadastro = LocalDate.now();
    }

}