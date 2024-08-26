package com.distribuidora.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.distribuidora.distribuidora.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
