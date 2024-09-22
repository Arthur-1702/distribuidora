package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.dto.FornecedorDTO;
import com.distribuidora.distribuidora.model.Fornecedor;
import com.distribuidora.distribuidora.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/fornecedores")

public class FornecedorController {

     @Autowired
    private FornecedorService fornecedorService;
    
    @PostMapping("/criarFornecedor")
     public ResponseEntity<String> criarFornecedor(@RequestBody FornecedorDTO fornecedor) {
        try{
            Fornecedor novoFornecedor = fornecedorService.cadastrarFornecedor(fornecedor);
            return ResponseEntity.ok("Fornecedor cadastrado com sucesso! ID: " + novoFornecedor.getCodFornecedor());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }
        
    @GetMapping("/listarFornecedores")
    public ResponseEntity<List<Fornecedor>> listarFornecedors() {
        try{
            List<Fornecedor> fornecedores = fornecedorService.listarFornecedors();
            return ResponseEntity.ok(fornecedores);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        try{
            Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(id);
            return ResponseEntity.ok(fornecedor);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody FornecedorDTO fornecedor) {
        try{
            Fornecedor fornecedorAtualizado = fornecedorService.atualizar(id, fornecedor);
            return ResponseEntity.ok("Fornecedor atualizado com sucesso! ID: " + id);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try{
            fornecedorService.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso! ID: " + id);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }
}