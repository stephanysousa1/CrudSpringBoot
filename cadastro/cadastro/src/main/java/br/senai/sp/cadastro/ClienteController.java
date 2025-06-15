package br.senai.sp.cadastro;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    // INJEÇÃO DE DEPENDENCIA AUTOMATICA
    @Autowired
    ClienteRepository clienteRepository;

    // --------- METODO GET ---------//

    @GetMapping
    public List<ClienteEntity> listarClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes;
    }

    // ------ BUSCA POR FILTROS ------ //


    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> buscarClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String cep,
            @RequestParam(required = false) String email) {

        Specification<ClienteEntity> specs = Specification.where(ClienteSpecification.nomeLike(nome))
                .and(ClienteSpecification.cpfLike(cpf))
                .and(ClienteSpecification.cepLike(cep))
                .and(ClienteSpecification.emailLike(email));

        List<ClienteEntity> clientes = clienteRepository.findAll(specs);

        List<ClienteDTO> dtos = new ArrayList<>();
        for (ClienteEntity cliente : clientes) {
            ClienteDTO dto = new ClienteDTO(
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getCpf(),
                    cliente.getDataNascimento(),
                    cliente.getTelefone(),
                    cliente.getEmail(),
                    cliente.getEndereco(),
                    cliente.getCep()
            );
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    //--------  METODO POST -------- //

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody @Valid ClienteDTO cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setDataNascimento(cliente.getDataNascimento());
        clienteEntity.setTelefone(cliente.getTelefone());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setEndereco(cliente.getEndereco());
        clienteEntity.setCep(cliente.getCep());

        clienteRepository.save(clienteEntity);

        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    // ------ METODO PUT ------ //

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteAtualizado) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            clienteEntity.setNome(clienteAtualizado.getNome());
            clienteEntity.setCpf(clienteAtualizado.getCpf());
            clienteEntity.setDataNascimento(clienteAtualizado.getDataNascimento());
            clienteEntity.setTelefone(clienteAtualizado.getTelefone());
            clienteEntity.setEmail(clienteAtualizado.getEmail());
            clienteEntity.setEndereco(clienteAtualizado.getEndereco());
            clienteEntity.setCep(clienteAtualizado.getCep());

            clienteRepository.save(clienteEntity);
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ------- METODO GET - BUSCANDO POR ID -------//

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable Long id) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            ClienteDTO cliente = new ClienteDTO(clienteEntity.getId(), clienteEntity.getNome(),
                    clienteEntity.getCpf(), clienteEntity.getDataNascimento(), clienteEntity.getTelefone(),
                    clienteEntity.getEmail(), clienteEntity.getEndereco(), clienteEntity.getCep()
            );
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // -------- METODO DELETE --------- //

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            clienteRepository.delete(clienteEntity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
