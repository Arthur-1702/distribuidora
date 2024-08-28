package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
