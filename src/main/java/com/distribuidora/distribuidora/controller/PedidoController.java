package com.distribuidora.distribuidora.controller;

import com.distribuidora.distribuidora.dto.PedidoDTO;
import com.distribuidora.distribuidora.model.Pedido;
import com.distribuidora.distribuidora.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criarPedido")
    public ResponseEntity<String> criarPedido(@RequestBody PedidoDTO pedido) {
        try {
            Pedido novoPedido = pedidoService.createPedido(pedido);
            return ResponseEntity.status(HttpStatus.OK).body("Pedido criado com sucesso! ID: "+ novoPedido.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("/listarPedidos")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        try {
            List<Pedido> pedidos = pedidoService.getAllPedidos();
            return ResponseEntity.ok(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        try {
            Pedido pedido = pedidoService.getPedidoById(id);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            Pedido updatedPedido = pedidoService.updatePedido(id, pedidoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Pedido atualizado com sucesso! ID: "+ updatedPedido.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id) {
        try {
            pedidoService.deletePedido(id);
            return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso! ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}
