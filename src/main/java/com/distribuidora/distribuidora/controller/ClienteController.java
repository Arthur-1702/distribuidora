package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.dto.ClienteDTO;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/clientes")

public class ClienteController {

     @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/criarCliente")
     public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO cliente) {
        try{
            Cliente novoCliente = clienteService.cadastrarCliente(cliente);
            return ResponseEntity.ok("Cliente cadastrado com sucesso! Cliente: " + novoCliente);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }
        
    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        try{
            List<Cliente> clientes = clienteService.listarClientes();
            return ResponseEntity.ok(clientes);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        try{
            Cliente cliente = clienteService.buscarClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        try{
            Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
            return ResponseEntity.ok("Cliente atualizado com sucesso! Cliente: " + clienteAtualizado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        try{
            clienteService.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso! Id: " + id);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }
}
