package com.distribuidora.distribuidora.service;

import com.distribuidora.distribuidora.dto.ProdutoDTO;
import com.distribuidora.distribuidora.model.Categoria;
import com.distribuidora.distribuidora.model.Embalagem;
import com.distribuidora.distribuidora.model.Fornecedor;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import com.distribuidora.distribuidora.repository.CategoriaRepository;
import com.distribuidora.distribuidora.repository.EmbalagemRepository;
import com.distribuidora.distribuidora.repository.FornecedorRepository;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private EmbalagemRepository embalagemRepository;

    public Produto createProduto(ProdutoDTO produtoDTO) {
        Produto produto = mapDtoToEntity(produtoDTO);
        return produtoRepository.save(produto);
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    }

    public Produto updateProduto(Long id, ProdutoDTO produtoDTO) {
        Produto existingProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
    
        // Mapear dados atualizados do DTO para a entidade existente
        Produto updatedProduto = mapDtoToEntity(produtoDTO);
    
        // Manter o código do produto existente
        updatedProduto.setCodProduto(existingProduto.getCodProduto());
    
        // Manter ou definir a data de cadastro
        if (updatedProduto.getDtCadastro() == null) {
            updatedProduto.setDtCadastro(existingProduto.getDtCadastro());
        }
    
        return produtoRepository.save(updatedProduto);
    }
    

    public void deleteProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        produtoRepository.delete(produto);
    }

    private Produto mapDtoToEntity(ProdutoDTO produtoDTO) {
        Fornecedor fornecedor = fornecedorRepository.findById(produtoDTO.getCodFornecedor())
                .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado"));
        Categoria categoria = categoriaRepository.findById(produtoDTO.getCodCategoria())
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
        Embalagem embalagem = embalagemRepository.findById(produtoDTO.getCodEmbalagem())
                .orElseThrow(() -> new ResourceNotFoundException("Embalagem não encontrada"));

        Produto produto = new Produto();
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setFornecedor(fornecedor);
        produto.setCategoria(categoria);
        produto.setVolume(produtoDTO.getVolume());
        produto.setEmbalagem(embalagem);
        produto.setCodFabrica(produtoDTO.getCodFabrica());
        produto.setCodigoBarras(produtoDTO.getCodigoBarras());

        return produto;
    }

}
