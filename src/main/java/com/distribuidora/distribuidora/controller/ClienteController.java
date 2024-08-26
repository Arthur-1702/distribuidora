package com.distribuidora.distribuidora.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distribuidora.distribuidora.service.ClienteService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3608)
@RequestMapping("/cliente")

public class ClienteController {
    
    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    
    
}
