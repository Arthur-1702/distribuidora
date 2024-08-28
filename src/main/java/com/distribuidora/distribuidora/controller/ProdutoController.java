package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.dto.ProdutoDTO;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/criarProduto")
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoDTO produto) {
        try {
            Produto novoProduto = produtoService.createProduto(produto);
            return ResponseEntity.ok(novoProduto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Produto produto = produtoService.getProdutoById(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Produto updatedProduto = produtoService.updateProduto(id, produtoDTO);
        return ResponseEntity.ok(updatedProduto);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
