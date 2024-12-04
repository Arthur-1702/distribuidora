package com.distribuidora.distribuidora.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

import com.distribuidora.distribuidora.dto.EstoqueDTO;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import com.distribuidora.distribuidora.model.Estoque;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.EstoqueRepository;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EstoqueServiceTest {

    @Mock
    private EstoqueRepository estoqueRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private EstoqueService estoqueService;

    public EstoqueServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateEstoqueSuccessfully() {
        // Arrange
        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setProdutoId(1L);
        estoqueDTO.setQtEstoqueGerencial(100);

        Produto produto = new Produto();
        produto.setCodProduto(1L);

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(estoqueRepository.findByProdutoCodProduto(1L)).thenReturn(Optional.empty());

        Estoque estoque = new Estoque();
        estoque.setQtEstoqueGerencial(100);
        when(estoqueRepository.save(any(Estoque.class))).thenReturn(estoque);

        // Act
        Estoque savedEstoque = estoqueService.createEstoque(estoqueDTO);

        // Assert
        assertNotNull(savedEstoque);
        assertEquals(100, savedEstoque.getQtEstoqueGerencial());
        verify(estoqueRepository, times(1)).save(any(Estoque.class));
    }

    @Test
    void shouldThrowExceptionWhenEstoqueAlreadyExists() {
        // Arrange
        EstoqueDTO estoqueDTO = new EstoqueDTO();
        estoqueDTO.setProdutoId(1L);

        Produto produto = new Produto();
        produto.setCodProduto(1L);

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        when(estoqueRepository.findByProdutoCodProduto(1L)).thenReturn(Optional.of(new Estoque()));

        // Act & Assert
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            estoqueService.createEstoque(estoqueDTO);
        });

        assertEquals("Estoque já existente para o produto com ID: 1", exception.getMessage());
    }
}
