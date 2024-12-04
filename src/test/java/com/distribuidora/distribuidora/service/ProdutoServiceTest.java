package com.distribuidora.distribuidora.service;

import static org.mockito.ArgumentMatchers.any;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.distribuidora.distribuidora.dto.ProdutoDTO;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import com.distribuidora.distribuidora.model.Categoria;
import com.distribuidora.distribuidora.model.Fornecedor;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.CategoriaRepository;
import com.distribuidora.distribuidora.repository.FornecedorRepository;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private ProdutoService produtoService;

    public ProdutoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

@Test
void shouldCreateProdutoSuccessfully() {
    // Arrange
    ProdutoDTO produtoDTO = new ProdutoDTO();
    produtoDTO.setNomeProduto("Produto Teste");
    produtoDTO.setCodCategoria(1); // Integer, não Long
    produtoDTO.setCodFornecedor(1);

    Categoria categoria = new Categoria();
    categoria.setCodCategoria(1); // Atributo correto e tipo Integer

    Fornecedor fornecedor = new Fornecedor();
    categoria.setCodCategoria(1);

    when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
    when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));

    Produto produto = new Produto();
    produto.setNomeProduto("Produto Teste");
    when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

    // Act
    Produto savedProduto = produtoService.createProduto(produtoDTO);

    // Assert
    assertNotNull(savedProduto);
    assertEquals("Produto Teste", savedProduto.getNomeProduto());
    verify(produtoRepository, times(1)).save(any(Produto.class));
}


    @Test
    void shouldThrowExceptionWhenCategoriaNotFound() {
        // Arrange
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCodCategoria(999L);

        when(categoriaRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            produtoService.createProduto(produtoDTO);
        });

        assertEquals("Categoria não encontrada", exception.getMessage());
    }
}
