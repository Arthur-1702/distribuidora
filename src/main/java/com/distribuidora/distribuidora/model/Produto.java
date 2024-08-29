package com.distribuidora.distribuidora.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TBPRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODPRODUTO")
    private long codProduto;

    @Column(name = "NOMEPRODUTO", nullable = false, length = 40)
    private String nomeProduto;

    @ManyToOne
    @JoinColumn(name = "CODFORNECEDOR", nullable = false)
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "CODCATEGORIA", nullable = false)
    private Categoria categoria;

    @Column(name = "VOLUME", nullable = false)
    private BigDecimal volume;

    @ManyToOne
    @JoinColumn(name = "CODEMBALAGEM", nullable = false)
    private Embalagem embalagem;

    @Column(name = "CODFABRICA", nullable = false,length = 20)
    private String codFabrica;

    @Column(name = "CODIGOBARRAS", nullable = false,length = 14)
    private String codigoBarras;

    @Column(name = "DTCADASTRO", nullable = false)
    private LocalDate dtCadastro;

    // Método que será chamado antes de persistir um novo registro
    @PrePersist
    protected void onCreate() {
        this.dtCadastro = LocalDate.now();
    }

    //Faça os construtores
    public Produto() {
    }

    public Produto(long codProduto, String nomeProduto, BigDecimal volume, String codFabrica, String codigoBarras, LocalDate dtCadastro) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.codFabrica = codFabrica;
        this.codigoBarras = codigoBarras;
    }

    //Faça os getters e setters
    public long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(long codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
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

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }
}