package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Estoque;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    
    Optional<Estoque> findByProdutoCodProduto(Long codProduto);

}
