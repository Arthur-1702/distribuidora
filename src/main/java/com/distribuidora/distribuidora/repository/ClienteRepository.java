package com.distribuidora.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.distribuidora.distribuidora.model.Cliente;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Consulta para verificar se existe um cliente com o CNPJ/CPF fornecido
    boolean existsByCgcEnt(String cgcEnt);

    // Consulta para verificar se existe um cliente com o código único fornecido
    boolean existsByCodCliente(Integer codCliente);

    // Consulta para encontrar um cliente pelo CNPJ/CPF
    Optional<Cliente> findByCgcEnt(String cgcEnt);

    // Consulta para encontrar um cliente pelo código único
    Optional<Cliente> findByCodCliente(Integer codCliente);
}
