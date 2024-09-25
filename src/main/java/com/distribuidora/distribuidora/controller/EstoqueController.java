package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.dto.EstoqueDTO;
import com.distribuidora.distribuidora.model.Estoque;
import com.distribuidora.distribuidora.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/estoques")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("/criarEstoque")
    public ResponseEntity<String> criarEstoque(@RequestBody EstoqueDTO estoque) {
        try {
            Estoque novoEstoque = estoqueService.createEstoque(estoque);
            return ResponseEntity.status(HttpStatus.OK).body("Estoque criado com sucesso! ID: "+ novoEstoque.getProduto());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/listarEstoques")
    public ResponseEntity<List<Estoque>> listarEstoques() {
        try {
            List<Estoque> estoques = estoqueService.getAllEstoques();
            return ResponseEntity.ok(estoques);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarEstoquePorId(@PathVariable Long id) {
        try {
            Estoque estoque = estoqueService.getEstoqueByProdutoId(id);
            return ResponseEntity.ok(estoque);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEstoque(@PathVariable Long id, @RequestBody EstoqueDTO estoqueDTO) {
        try {
            Estoque updatedEstoque = estoqueService.updateEstoque(id, estoqueDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Estoque atualizado com sucesso! ID: "+ updatedEstoque.getProduto());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEstoque(@PathVariable Long id) {
        try {
            estoqueService.deleteEstoque(id);
            return ResponseEntity.status(HttpStatus.OK).body("Estoque deletado com sucesso! ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}
