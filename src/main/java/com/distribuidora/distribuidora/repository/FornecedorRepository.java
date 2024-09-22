package com.distribuidora.distribuidora.repository;

import com.distribuidora.distribuidora.model.Fornecedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
     // Consulta para verificar se existe um fornecedor com o CNPJ/CPF fornecido
    boolean existsByCnpj(String cnpj);

    // Consulta para verificar se existe um fornecedor com o código único fornecido
    boolean existsByCodFornecedor(Long codFornecedor);

    // Consulta para encontrar um fornecedor pelo CNPJ/CPF
    Optional<Fornecedor> findByCnpj(String cnpj);

    // Consulta para encontrar um fornecedor pelo código único
    Optional<Fornecedor> findByCodFornecedor(Long codFornecedor);
}
