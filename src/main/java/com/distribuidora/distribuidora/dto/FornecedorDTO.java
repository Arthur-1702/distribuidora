package com.distribuidora.distribuidora.dto;

import java.time.LocalDate;

public class FornecedorDTO {
    private String nomeFornecedor;
    private String cnpj;
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
    private Long planoPagamentoId;
    private Long clienteId;
    private LocalDate dtCadastro;

    // Getters e Setters

    public Long getPlanoPagamentoId() {
        return planoPagamentoId;
    }

    public void setPlanoPagamentoId(Long planoPagamentoId) {
        this.planoPagamentoId = planoPagamentoId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
