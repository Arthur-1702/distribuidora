package com.distribuidora.distribuidora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.distribuidora.distribuidora.dto.ClienteDTO;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.model.PlanoPagamento;
import com.distribuidora.distribuidora.repository.ClienteRepository;
import com.distribuidora.distribuidora.repository.PlanoPagamentoRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PlanoPagamentoRepository planoPagamentoRepository;

    public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapDtoToEntity(clienteDTO);
        validarCnpj(cliente.getCgcEnt());

        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (temTransacoesPendentes(clienteExistente)) {
            throw new RuntimeException("Não é possível atualizar um cliente com transações pendentes.");
        }

        Cliente clienteAtualizado = mapDtoToEntity(clienteDTO);
        
         // Manter o código do produto existente
         clienteAtualizado.setCodCliente(clienteExistente.getCodCliente());
    
         // Manter ou definir a data de cadastro
         if (clienteAtualizado.getDtCadastro() == null) {
            clienteAtualizado.setDtCadastro(clienteExistente.getDtCadastro());
         }

        return clienteRepository.save(clienteAtualizado);
    }

    @Transactional
    public void excluir(Long id) {
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

    private void validarCodigoUnico(Long codCliente) {
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
        PlanoPagamento planoPagamento = planoPagamentoRepository.findById(clienteDTO.getPrazoPagamento())
                .orElseThrow(() -> new ResourceNotFoundException("Plano Pagamento não encontrado"));

        Cliente cliente = new Cliente();

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
        cliente.setPlanoPagamento(planoPagamento);
        return cliente;
    }
}
