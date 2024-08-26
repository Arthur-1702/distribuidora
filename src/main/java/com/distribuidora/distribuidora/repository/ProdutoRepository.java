package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
