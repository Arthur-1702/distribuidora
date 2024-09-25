package com.distribuidora.distribuidora.service;

import com.distribuidora.distribuidora.dto.PedidoDTO;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.model.Pedido;
import com.distribuidora.distribuidora.model.Produto;
import com.distribuidora.distribuidora.repository.ClienteRepository;
import com.distribuidora.distribuidora.repository.PedidoRepository;
import com.distribuidora.distribuidora.repository.ProdutoRepository;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    
    public Pedido createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = mapDtoToEntity(pedidoDTO);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }

    public Pedido updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        Pedido updatedPedido = mapDtoToEntity(pedidoDTO);
        updatedPedido.setId(existingPedido.getId()); // Mantém o mesmo ID

        return pedidoRepository.save(updatedPedido);
    }

    public void deletePedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
        pedidoRepository.delete(pedido);
    }

    private Pedido mapDtoToEntity(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(pedidoDTO.getProdutoId())
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setDataEntrega(pedidoDTO.getDataEntrega());

        return pedido;
    }
}
