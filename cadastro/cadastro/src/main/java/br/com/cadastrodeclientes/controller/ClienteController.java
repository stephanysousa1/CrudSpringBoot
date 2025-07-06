package br.com.cadastrodeclientes.controller;

import br.com.cadastrodeclientes.dto.ClienteDTO;
import br.com.cadastrodeclientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    // INJEÇÃO DE DEPENDENCIA AUTOMATICA
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> lista = clienteService.listar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody @Valid ClienteDTO cliente) {

        ClienteDTO clienteCriado = clienteService.adicionarCliente(cliente);
        return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteAtualizado) {

           ClienteDTO atualizado = clienteService.atualizarCliente(id,clienteAtualizado);
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterCliente(@PathVariable Long id) {

           ClienteDTO cliente = clienteService.buscarId(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}
