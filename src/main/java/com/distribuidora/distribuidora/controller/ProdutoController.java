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
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produto) {
        try {
            Produto novoProduto = produtoService.createProduto(produto);
            return ResponseEntity.status(HttpStatus.OK).body("Produto criado com sucesso! Produto: "+novoProduto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        try {
            List<Produto> produtos = produtoService.getAllProdutos();
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        try {
            Produto produto = produtoService.getProdutoById(id);
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        try {
            Produto updatedProduto = produtoService.updateProduto(id, produtoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado com sucesso! Produto: " + updatedProduto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            produtoService.deleteProduto(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso! Id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}
