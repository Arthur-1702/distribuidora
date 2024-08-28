package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Embalagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbalagemRepository extends JpaRepository<Embalagem, Long> {
    
}
