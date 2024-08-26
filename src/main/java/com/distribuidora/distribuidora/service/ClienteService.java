package com.distribuidora.distribuidora.service;

import org.springframework.stereotype.Service;
import com.distribuidora.distribuidora.repository.ClienteRepository;

@Service //ponto de injeção de dependências
public class ClienteService {
    
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

}
