package com.distribuidora.distribuidora.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String nomeProduto;
    private Long codFornecedor;
    private Long codCategoria;
    private BigDecimal volume;
    private Long codEmbalagem;
    private String codFabrica;
    private String codigoBarras;

    // getters e setters
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public long getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(long codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getCodFabrica() {
        return codFabrica;
    }

    public void setCodFabrica(String codFabrica) {
        this.codFabrica = codFabrica;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public long getCodEmbalagem() {
        return codEmbalagem;
    }

    public void setCodEmbalagem(long codEmbalagem) {
        this.codEmbalagem = codEmbalagem;
    }
}
