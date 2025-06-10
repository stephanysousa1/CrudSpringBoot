package br.senai.sp.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClienteController {

    ClienteRepository clienteRepository;


    public List<ClienteEntity> listarClientes() {

        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes;
    }


    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {

        ClienteEntity clienteEntity = new ClienteEntity();



        clienteRepository.save(clienteEntity);


        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }


    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {


        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);



            clienteEntity.setNome(clienteAtualizado.getNome());
            clienteEntity.setEmail(clienteAtualizado.getEmail());
            clienteRepository.save(clienteEntity);

            return new ResponseEntity<>(clienteAtualizado, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {


        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);


        if(clienteEntity != null) {
            Cliente cliente = new Cliente(clienteEntity.getId(), clienteEntity.getNome(),
                    clienteEntity.getCpf(),  clienteEntity.getDataNascimento(), clienteEntity.getTelefone(), clienteEntity.getEmail(),
                    clienteEntity.getEndereco(), clienteEntity.getCep());
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);


            clienteRepository.delete(clienteEntity);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
