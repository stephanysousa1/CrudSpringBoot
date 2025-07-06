package br.com.cadastrodeclientes.service;

import br.com.cadastrodeclientes.dto.ClienteDTO;
import br.com.cadastrodeclientes.entity.ClienteEntity;
import br.com.cadastrodeclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    // dto para entity

    public ClienteEntity toEntity(ClienteDTO cliente) {
        return ClienteEntity.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .telefone(cliente.getTelefone())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .cep(cliente.getCep())
                .build();
    }

    //  entity para dto
    public ClienteDTO toDTO(ClienteEntity cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .dataNascimento(cliente.getDataNascimento())
                .telefone(cliente.getTelefone())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .cep(cliente.getCep())
                .build();
    }

    // GET
    public List<ClienteDTO> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET ID
    public ClienteDTO buscarId(Long id) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDTO(entity);
    }

    // POST
    public ClienteDTO adicionarCliente(ClienteDTO dto) {
        if (clienteRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        // Converte DTO → Entity
        ClienteEntity entity = toEntity(dto);
        // Salva no banco
        ClienteEntity clienteSalvo = clienteRepository.save(entity);
        // Converte Entity → DTO e devolve
        return toDTO(clienteSalvo);
    }

    // PUT
    public ClienteDTO atualizarCliente(Long id, ClienteDTO dto) {

        // Busca o cliente Existente
        ClienteEntity clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (!clienteExistente.getCpf().equals(dto.getCpf())
                && clienteRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado para outro cliente");
        }

        // Atualiza campos
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setCpf(dto.getCpf());
        clienteExistente.setDataNascimento(dto.getDataNascimento());
        clienteExistente.setTelefone(dto.getTelefone());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setEndereco(dto.getEndereco());
        clienteExistente.setCep(dto.getCep());

        // salva no banco
        ClienteEntity clienteAtualizado = clienteRepository.save(clienteExistente);

        return toDTO(clienteAtualizado);

    }

    public void deletarCliente(Long id) {

        ClienteEntity cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));


        clienteRepository.delete(cliente);
    }
}

