package com.distribuidora.distribuidora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.repository.ClienteRepository;

import java.util.List;

@Service // ponto de injeção de dependências
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional
    public Cliente atualizar(Integer id, Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
                validarCnpj(clienteAtualizado.getCgcEnt());
                validarCodigoUnico(clienteAtualizado.getCodCliente());    
                    if (temTransacoesPendentes(clienteExistente)) {
                        throw new RuntimeException("Não é possível atualizar um cliente com transações pendentes.");
                    }
         return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void excluir(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        if (temTransacoesPendentes(cliente)) {
            throw new RuntimeException("Não é possível excluir um cliente com transações pendentes.");
        }
        clienteRepository.delete(cliente);
    }

    private void validarCnpj(String cgcEnt) {
        // Verifica se o CNPJ/CPF é válido e se já existe no sistema
        if (!isValidCnpj(cgcEnt)) {
            throw new RuntimeException("CNPJ/CPF inválido.");
        }
        if (clienteRepository.existsByCgcEnt(cgcEnt)) {
            throw new RuntimeException("CNPJ/CPF já cadastrado.");
        }
    }

    private void validarCodigoUnico(Integer codCliente) {
        // Lógica para validar o código único do cliente
        if (clienteRepository.existsByCodCliente(codCliente)) {
            throw new RuntimeException("Código de cliente já cadastrado.");
        }
    }

    private boolean temTransacoesPendentes(Cliente cliente) {
        // Implementar lógica para verificar transações pendentes
        return false;
    }

    private boolean isValidCnpj(String cgcEnt) {
        // Implementar validação de CNPJ/CPF
        return true; // Substituir com a lógica real
    }
}
