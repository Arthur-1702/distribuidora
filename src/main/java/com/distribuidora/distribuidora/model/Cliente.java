package com.distribuidora.distribuidora.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBCLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODCLIENTE")
    private Integer codCliente;

    @Column(name = "NOMECLIENTE", nullable = false, length = 40)
    private String nomeCliente;

    @Column(name = "CGCENT", nullable = false, length = 30)
    private String cgcEnt; // Pode ser usado tanto para CNPJ quanto para CPF

    @Column(name = "RAMOATIVIDADE", nullable = false, length = 50)
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

    @Column(name = "CEPCOM", nullable = false, length = 20)
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

    @Column(name = "CEPENT", length = 10)
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

    @Column(name = "CEPCOB", length = 15)
    private String cepCobranca;

    @Column(name = "TELEFONE", nullable = false, length = 15)
    private String telefone;

    @Column(name = "EMAIL", nullable = false, length = 50)
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

    //Faça os construtores

    public Cliente() {
    }

    public Cliente(Integer codCliente, String nomeCliente, String cgcEnt, String ramoAtividade, String enderecoComercial, String complementoComercial, String bairroComercial, String cidadeComercial, String ufComercial, String cepComercial, String telefone, String email, LocalDate dtCadastro) {
        this.codCliente = codCliente;
        this.nomeCliente = nomeCliente;
        this.cgcEnt = cgcEnt;
        this.ramoAtividade = ramoAtividade;
        this.enderecoComercial = enderecoComercial;
        this.complementoComercial = complementoComercial;
        this.bairroComercial = bairroComercial;
        this.cidadeComercial = cidadeComercial;
        this.ufComercial = ufComercial;
        this.cepComercial = cepComercial;
        this.telefone = telefone;
        this.email = email;
    }

    //Faça os getters e setters

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCgcEnt() {
        return cgcEnt;
    }

    public void setCgcEnt(String cgcEnt) {
        this.cgcEnt = cgcEnt;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getEnderecoComercial() {
        return enderecoComercial;
    }

    public void setEnderecoComercial(String enderecoComercial) {
        this.enderecoComercial = enderecoComercial;
    }

    public String getComplementoComercial() {
        return complementoComercial;
    }

    public void setComplementoComercial(String complementoComercial) {
        this.complementoComercial = complementoComercial;
    }

    public String getBairroComercial() {
        return bairroComercial;
    }

    public void setBairroComercial(String bairroComercial) {
        this.bairroComercial = bairroComercial;
    }

    public String getCidadeComercial() {
        return cidadeComercial;
    }

    public void setCidadeComercial(String cidadeComercial) {
        this.cidadeComercial = cidadeComercial;
    }

    public String getUfComercial() {
        return ufComercial;
    }

    public void setUfComercial(String ufComercial) {
        this.ufComercial = ufComercial;
    }

    public String getCepComercial() {
        return cepComercial;
    }

    public void setCepComercial(String cepComercial) {
        this.cepComercial = cepComercial;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getComplementoEntrega() {
        return complementoEntrega;
    }

    public void setComplementoEntrega(String complementoEntrega) {
        this.complementoEntrega = complementoEntrega;
    }

    public String getBairroEntrega() {
        return bairroEntrega;
    }

    public void setBairroEntrega(String bairroEntrega) {
        this.bairroEntrega = bairroEntrega;
    }

    public String getCidadeEntrega() {
        return cidadeEntrega;
    }

    public void setCidadeEntrega(String cidadeEntrega) {
        this.cidadeEntrega = cidadeEntrega;
    }

    public String getUfEntrega() {
        return ufEntrega;
    }

    public void setUfEntrega(String ufEntrega) {
        this.ufEntrega = ufEntrega;
    }

    public String getCepEntrega() {
        return cepEntrega;
    }

    public void setCepEntrega(String cepEntrega) {
        this.cepEntrega = cepEntrega;
    }

    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public String getComplementoCobranca() {
        return complementoCobranca;
    }

    public void setComplementoCobranca(String complementoCobranca) {
        this.complementoCobranca = complementoCobranca;
    }

    public String getBairroCobranca() {
        return bairroCobranca;
    }

    public void setBairroCobranca(String bairroCobranca) {
        this.bairroCobranca = bairroCobranca;
    }

    public String getCidadeCobranca() {
        return cidadeCobranca;
    }

    public void setCidadeCobranca(String cidadeCobranca) {
        this.cidadeCobranca = cidadeCobranca;
    }

    public String getUfCobranca() {
        return ufCobranca;
    }

    public void setUfCobranca(String ufCobranca) {
        this.ufCobranca = ufCobranca;
    }

    public String getCepCobranca() {
        return cepCobranca;
    }

    public void setCepCobranca(String cepCobranca) {
        this.cepCobranca = cepCobranca;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContatoCargo1() {
        return contatoCargo1;
    }

    public void setContatoCargo1(String contatoCargo1) {
        this.contatoCargo1 = contatoCargo1;
    }

    public String getContatoNome1() {
        return contatoNome1;
    }

    public void setContatoNome1(String contatoNome1) {
        this.contatoNome1 = contatoNome1;
    }

    public String getContatoCpf1() {
        return contatoCpf1;
    }

    public void setContatoCpf1(String contatoCpf1) {
        this.contatoCpf1 = contatoCpf1;
    }

    public String getContatoCargo2() {
        return contatoCargo2;
    }

    public void setContatoCargo2(String contatoCargo2) {
        this.contatoCargo2 = contatoCargo2;
    }

    public String getContatoNome2() {
        return contatoNome2;
    }

    public void setContatoNome2(String contatoNome2) {
        this.contatoNome2 = contatoNome2;
    }

    public String getContatoCpf2() {
        return contatoCpf2;
    }

    public void setContatoCpf2(String contatoCpf2) {
        this.contatoCpf2 = contatoCpf2;
    }

    public String getContatoCargo3() {
        return contatoCargo3;
    }

    public void setContatoCargo3(String contatoCargo3) {
        this.contatoCargo3 = contatoCargo3;
    }

    public String getContatoNome3() {
        return contatoNome3;
    }

    public void setContatoNome3(String contatoNome3) {
        this.contatoNome3 = contatoNome3;
    }

    public String getContatoCpf3() {
        return contatoCpf3;
    }

    public void setContatoCpf3(String contatoCpf3) {
        this.contatoCpf3 = contatoCpf3;
    }

    public PlanoPagamento getPlanoPagamento() {
        return planoPagamento;
    }

    public void setPlanoPagamento(PlanoPagamento planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

}