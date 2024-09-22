package com.distribuidora.distribuidora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.distribuidora.distribuidora.dto.FornecedorDTO;
import com.distribuidora.distribuidora.exception.ResourceNotFoundException;
import com.distribuidora.distribuidora.model.Fornecedor;
import com.distribuidora.distribuidora.model.PlanoPagamento;
import com.distribuidora.distribuidora.model.Cliente;
import com.distribuidora.distribuidora.repository.FornecedorRepository;
import com.distribuidora.distribuidora.repository.PlanoPagamentoRepository;
import com.distribuidora.distribuidora.repository.ClienteRepository;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private PlanoPagamentoRepository planoPagamentoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public Fornecedor cadastrarFornecedor(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = mapDtoToEntity(fornecedorDTO);
        validarCnpj(fornecedor.getCnpj());

        return fornecedorRepository.save(fornecedor);
    }
    
    public List<Fornecedor> listarFornecedors() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado"));
    }

    public Fornecedor atualizar(Long id, FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        if (temTransacoesPendentes(fornecedorExistente)) {
            throw new RuntimeException("Não é possível atualizar um fornecedor com transações pendentes.");
        }

        Fornecedor fornecedorAtualizado = mapDtoToEntity(fornecedorDTO);
        
         // Manter o código do produto existente
         fornecedorAtualizado.setCodFornecedor(fornecedorExistente.getCodFornecedor());
    
         // Manter ou definir a data de cadastro
         if (fornecedorAtualizado.getDtCadastro() == null) {
            fornecedorAtualizado.setDtCadastro(fornecedorExistente.getDtCadastro());
         }

        return fornecedorRepository.save(fornecedorAtualizado);
    }

    @Transactional
    public void excluir(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
        if (temTransacoesPendentes(fornecedor)) {
            throw new RuntimeException("Não é possível excluir um fornecedor com transações pendentes.");
        }
        fornecedorRepository.delete(fornecedor);
    }

    private void validarCnpj(String cnpj) {
        // Verifica se o CNPJ/CPF é válido e se já existe no sistema
        if (!isValidCnpj(cnpj)) {
            throw new RuntimeException("CNPJ/CPF inválido.");
        }
        if (fornecedorRepository.existsByCnpj(cnpj)) {
            throw new RuntimeException("CNPJ/CPF já cadastrado.");
        }
    }

    private void validarCodigoUnico(Long codFornecedor) {
        // Lógica para validar o código único do fornecedor
        if (fornecedorRepository.existsByCodFornecedor(codFornecedor)) {
            throw new RuntimeException("Código de fornecedor já cadastrado.");
        }
    }

    private boolean temTransacoesPendentes(Fornecedor fornecedor) {
        // Implementar lógica para verificar transações pendentes
        return false;
    }

    private boolean isValidCnpj(String cnpj) {
        // Implementar validação de CNPJ/CPF
        return true; // Substituir com a lógica real
    }
    public Fornecedor mapDtoToEntity(FornecedorDTO fornecedorDTO) {
        PlanoPagamento planoPagamento = planoPagamentoRepository.findById(fornecedorDTO.getPlanoPagamentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Plano Pagamento não encontrado"));

        Cliente cliente = clienteRepository.findById(fornecedorDTO.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNomeFornecedor(fornecedorDTO.getNomeFornecedor());
        fornecedor.setCnpj(fornecedorDTO.getCnpj());
        fornecedor.setEnderecoComercial(fornecedorDTO.getEnderecoComercial());
        fornecedor.setComplementoComercial(fornecedorDTO.getComplementoComercial());
        fornecedor.setBairroComercial(fornecedorDTO.getBairroComercial());
        fornecedor.setCidadeComercial(fornecedorDTO.getCidadeComercial());
        fornecedor.setUfComercial(fornecedorDTO.getUfComercial());
        fornecedor.setCepComercial(fornecedorDTO.getCepComercial());
        fornecedor.setEnderecoEntrega(fornecedorDTO.getEnderecoEntrega());
        fornecedor.setComplementoEntrega(fornecedorDTO.getComplementoEntrega());
        fornecedor.setBairroEntrega(fornecedorDTO.getBairroEntrega());
        fornecedor.setCidadeEntrega(fornecedorDTO.getCidadeEntrega());
        fornecedor.setUfEntrega(fornecedorDTO.getUfEntrega());
        fornecedor.setCepEntrega(fornecedorDTO.getCepEntrega());
        fornecedor.setEnderecoCobranca(fornecedorDTO.getEnderecoCobranca());
        fornecedor.setComplementoCobranca(fornecedorDTO.getComplementoCobranca());
        fornecedor.setBairroCobranca(fornecedorDTO.getBairroCobranca());
        fornecedor.setCidadeCobranca(fornecedorDTO.getCidadeCobranca());
        fornecedor.setUfCobranca(fornecedorDTO.getUfCobranca());
        fornecedor.setCepCobranca(fornecedorDTO.getCepCobranca());
        fornecedor.setTelefone(fornecedorDTO.getTelefone());
        fornecedor.setEmail(fornecedorDTO.getEmail());
        fornecedor.setDtCadastro(fornecedorDTO.getDtCadastro());
        fornecedor.setPlanoPagamento(planoPagamento);
        fornecedor.setCliente(cliente);
        return fornecedor;
    }
}
