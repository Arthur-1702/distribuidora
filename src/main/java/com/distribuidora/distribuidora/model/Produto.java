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

    @Column(name = "VOLUME", nullable = false, precision = 6, scale = 2)
    private BigDecimal volume;

    @ManyToOne
    @JoinColumn(name = "CODEMBALAGEM", nullable = false)
    private Embalagem embalagem;

    @Column(name = "CODFABRICA", nullable = false, length = 20)
    private String codFabrica;

    @Column(name = "CODIGOBARRAS", nullable = false, length = 14)
    private String codigoBarras;

    @Column(name = "DTCADASTRO", nullable = false)
    private LocalDate dtCadastro;

    // Método que será chamado antes de persistir um novo registro
    @PrePersist
    protected void onCreate() {
        this.dtCadastro = LocalDate.now();
    }
}