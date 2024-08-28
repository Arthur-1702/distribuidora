package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/cliente")

public class ClienteController {

     @Autowired
    private ClienteService clienteService;
    
    @PostMapping
     public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping("/listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.atualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
