package com.distribuidora.distribuidora.service;

import com.distribuidora.distribuidora.dto.EstoqueDTO;
import com.distribuidora.distribuidora.model.Estoque;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.EstoqueRepository;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
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
        Estoque estoque = mapDtoToEntity(estoqueDTO);
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    public Estoque getEstoqueByProdutoId(Long codProduto) {
        return estoqueRepository.findByProdutoCodProduto(codProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com código: " + codProduto));
    }

    public Estoque updateEstoque(Long codProduto, EstoqueDTO estoqueDTO) {
        Estoque existingEstoque = estoqueRepository.findByProdutoCodProduto(codProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com código: " + codProduto));
        
        Estoque updatedEstoque = mapDtoToEntity(estoqueDTO);
        updatedEstoque.setProduto(existingEstoque.getProduto()); // Mantenha o mesmo produto

        return estoqueRepository.save(updatedEstoque);
    }

    public void deleteEstoque(Long codProduto) {
        Estoque estoque = estoqueRepository.findByProdutoCodProduto(codProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado para o produto com código: " + codProduto));
        estoqueRepository.delete(estoque);
    }

    private Estoque mapDtoToEntity(EstoqueDTO estoqueDTO) {
        Produto produto = produtoRepository.findById(estoqueDTO.getProdutoId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQtEstoqueGerencial(estoqueDTO.getQtEstoqueGerencial());
        estoque.setQtTransito(estoqueDTO.getQtTransito());
        estoque.setQtDisponivel(estoqueDTO.getQtDisponivel());
        estoque.setQtReservada(estoqueDTO.getQtReservada());
        estoque.setDtValidade(estoqueDTO.getDtValidade());
        estoque.setDtUltEntrada(estoqueDTO.getDtUltEntrada());
        estoque.setGiroProduto(estoqueDTO.getGiroProduto());

        return estoque;
    }
}
