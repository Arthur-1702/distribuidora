package com.distribuidora.distribuidora.service;

import com.distribuidora.distribuidora.dto.EstoqueDTO;
import com.distribuidora.distribuidora.model.Estoque;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.EstoqueRepository;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Estoque createEstoque(EstoqueDTO estoqueDTO) {
        // Busca o produto no banco de dados pelo ID do produto
        Produto produto = produtoRepository.findById(estoqueDTO.getProdutoId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + estoqueDTO.getProdutoId()));

        // Verifica se o estoque já existe para este produto
        if (estoqueRepository.findByProdutoCodProduto(produto.getCodProduto()).isPresent()) {
            throw new ResourceNotFoundException("Estoque já existente para o produto com ID: " + produto.getCodProduto());
        }

        // Mapeia o DTO para a entidade Estoque e cria um novo estoque
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQtEstoqueGerencial(estoqueDTO.getQtEstoqueGerencial());
        estoque.setQtTransito(estoqueDTO.getQtTransito());
        estoque.setQtDisponivel(estoqueDTO.getQtDisponivel());
        estoque.setQtReservada(estoqueDTO.getQtReservada());
        estoque.setDtValidade(estoqueDTO.getDtValidade());
        estoque.setDtUltEntrada(estoqueDTO.getDtUltEntrada());
        estoque.setGiroProduto(estoqueDTO.getGiroProduto());

        // Salva o novo estoque no banco de dados
        return estoqueRepository.save(estoque);
    }


    public List<Estoque> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    public Estoque getEstoqueByProdutoId(Long codProduto) {
        return estoqueRepository.findByProdutoCodProduto(codProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com código: " + codProduto));
    }

    public Estoque updateEstoque(Long produtoId, EstoqueDTO estoqueDTO) {
        // Busca o produto no banco de dados
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com o ID: " + produtoId));

        // Busca o estoque existente pelo produto
        Estoque estoque = estoqueRepository.findByProdutoCodProduto(produto.getCodProduto())
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com ID: " + produtoId));

        // Atualiza os dados do estoque com base no DTO
        estoque.setQtEstoqueGerencial(estoqueDTO.getQtEstoqueGerencial());
        estoque.setQtTransito(estoqueDTO.getQtTransito());
        estoque.setQtDisponivel(estoqueDTO.getQtDisponivel());
        estoque.setQtReservada(estoqueDTO.getQtReservada());
        estoque.setDtValidade(estoqueDTO.getDtValidade());
        estoque.setDtUltEntrada(estoqueDTO.getDtUltEntrada());
        estoque.setGiroProduto(estoqueDTO.getGiroProduto());

        // Salva as atualizações no banco de dados
        return estoqueRepository.save(estoque);
    }

    public void deleteEstoque(Long codProduto) {
        Estoque estoque = estoqueRepository.findByProdutoCodProduto(codProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com código: " + codProduto));
        estoqueRepository.delete(estoque);
    }
}
