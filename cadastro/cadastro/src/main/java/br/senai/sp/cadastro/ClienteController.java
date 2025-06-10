package br.senai.sp.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteEntity> listarClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if(clienteEntity != null) {
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

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if(clienteEntity != null) {
            Cliente cliente = new Cliente(clienteEntity.getId(), clienteEntity.getNome(),
                    clienteEntity.getCpf(),clienteEntity.getDataNascimento(), clienteEntity.getTelefone(),
                    clienteEntity.getEmail(),clienteEntity.getEndereco(), clienteEntity.getCep()
                    );
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {

        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if(clienteEntity != null) {
            clienteRepository.delete(clienteEntity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
