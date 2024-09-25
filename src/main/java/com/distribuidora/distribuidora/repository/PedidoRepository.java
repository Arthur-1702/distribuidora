package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
