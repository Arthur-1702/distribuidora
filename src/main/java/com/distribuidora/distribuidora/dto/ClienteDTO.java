package com.distribuidora.distribuidora.dto;

import java.time.LocalDate;

public class ClienteDTO {
    private Long prazoPagamento; 
    private String nomeCliente;
    private String cgcEnt; // Pode ser usado tanto para CNPJ quanto para CPF
    private String ramoAtividade;
    private String enderecoComercial;
    private String complementoComercial;
    private String bairroComercial;
    private String cidadeComercial;
    private String ufComercial;
    private String cepComercial;
    private String enderecoEntrega;
    private String complementoEntrega;
    private String bairroEntrega;
    private String cidadeEntrega;
    private String ufEntrega;
    private String cepEntrega;
    private String enderecoCobranca;
    private String complementoCobranca;
    private String bairroCobranca;
    private String cidadeCobranca;
    private String ufCobranca;
    private String cepCobranca;
    private String telefone;
    private String email;
    private String contatoCargo1;
    private String contatoNome1;
    private String contatoCpf1;
    private String contatoCargo2;
    private String contatoNome2;
    private String contatoCpf2;
    private String contatoCargo3;
    private String contatoNome3;
    private String contatoCpf3;
    private LocalDate dtCadastro;

    // Getters e Setters

    public Long getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(Long prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
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

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
