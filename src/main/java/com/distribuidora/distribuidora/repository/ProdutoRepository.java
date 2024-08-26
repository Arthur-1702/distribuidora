package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAll();
    void deleteById(Long id);
}
