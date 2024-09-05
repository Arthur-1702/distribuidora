package com.distribuidora.distribuidora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.distribuidora.distribuidora.dto.ClienteDTO;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.repository.ClienteRepository;

import java.util.List;

@Service // ponto de injeção de dependências
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapDtoToEntity(clienteDTO);
        return clienteRepository.save(cliente);
    }
    

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
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
    public Cliente mapDtoToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setCodCliente(clienteDTO.getCodCliente());
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setCgcEnt(clienteDTO.getCgcEnt());
        cliente.setRamoAtividade(clienteDTO.getRamoAtividade());
        cliente.setEnderecoComercial(clienteDTO.getEnderecoComercial());
        cliente.setComplementoComercial(clienteDTO.getComplementoComercial());
        cliente.setBairroComercial(clienteDTO.getBairroComercial());
        cliente.setCidadeComercial(clienteDTO.getCidadeComercial());
        cliente.setUfComercial(clienteDTO.getUfComercial());
        cliente.setCepComercial(clienteDTO.getCepComercial());
        cliente.setEnderecoEntrega(clienteDTO.getEnderecoEntrega());
        cliente.setComplementoEntrega(clienteDTO.getComplementoEntrega());
        cliente.setBairroEntrega(clienteDTO.getBairroEntrega());
        cliente.setCidadeEntrega(clienteDTO.getCidadeEntrega());
        cliente.setUfEntrega(clienteDTO.getUfEntrega());
        cliente.setCepEntrega(clienteDTO.getCepEntrega());
        cliente.setEnderecoCobranca(clienteDTO.getEnderecoCobranca());
        cliente.setComplementoCobranca(clienteDTO.getComplementoCobranca());
        cliente.setBairroCobranca(clienteDTO.getBairroCobranca());
        cliente.setCidadeCobranca(clienteDTO.getCidadeCobranca());
        cliente.setUfCobranca(clienteDTO.getUfCobranca());
        cliente.setCepCobranca(clienteDTO.getCepCobranca());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setContatoCargo1(clienteDTO.getContatoCargo1());
        cliente.setContatoNome1(clienteDTO.getContatoNome1());
        cliente.setContatoCpf1(clienteDTO.getContatoCpf1());
        cliente.setContatoCargo2(clienteDTO.getContatoCargo2());
        cliente.setContatoNome2(clienteDTO.getContatoNome2());
        cliente.setContatoCpf2(clienteDTO.getContatoCpf2());
        cliente.setContatoCargo3(clienteDTO.getContatoCargo3());
        cliente.setContatoNome3(clienteDTO.getContatoNome3());
        cliente.setContatoCpf3(clienteDTO.getContatoCpf3());
        cliente.setDtCadastro(clienteDTO.getDtCadastro());

        // Se houver necessidade de mapear o plano de pagamento:
        // cliente.setPlanoPagamento(clienteDTO.getPlanoPagamento());

        return cliente;
    }
}
