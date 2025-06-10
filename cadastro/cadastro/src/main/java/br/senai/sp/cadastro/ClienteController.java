package br.senai.sp.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Indica que esta classe é um controlador REST
@RequestMapping("/clientes")  // Define o caminho base para todas as rotas
@CrossOrigin("*")  // Permite requisições de qualquer origem (CORS)
public class ClienteController {

    @Autowired  // Injeta automaticamente a dependência do repositório
    ClienteRepository clienteRepository;

    @GetMapping  // Mapeia requisições GET para /clientes
    public List<ClienteEntity> listarClientes() {
        // Busca todos os clientes no banco de dados
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes;
    }

    @PostMapping  // Mapeia requisições POST para /clientes
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        // Converte o DTO Cliente para a entidade ClienteEntity
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(cliente.getNome());  // Define o nome
        clienteEntity.setEmail(cliente.getEmail());  // Define o email

        // Salva a entidade no banco de dados
        clienteRepository.save(clienteEntity);

        // Retorna o DTO enviado com status 201 CREATED
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")  // Mapeia requisições PUT para /clientes/{id}
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {

        // Obtém referência à entidade existente pelo ID
        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            // Atualiza os campos da entidade
            clienteEntity.setNome(clienteAtualizado.getNome());
            clienteEntity.setEmail(clienteAtualizado.getEmail());
            clienteRepository.save(clienteEntity);  // Persiste alterações
            // Retorna o DTO atualizado com status 201 CREATED
            return new ResponseEntity<>(clienteAtualizado, HttpStatus.CREATED);
        }
        // Caso não encontre, retorna 404 NOT FOUND
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")  // Mapeia requisições GET para /clientes/{id}
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long id) {

        // Obtém referência à entidade pelo ID
        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            // Converte a entidade para DTO
            Cliente cliente = new Cliente(clienteEntity.getId(), clienteEntity.getNome(), clienteEntity.getEmail());
            // Retorna o DTO com status 200 OK
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        // Se não encontrar, retorna 404 NOT FOUND
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")  // Mapeia requisições DELETE para /clientes/{id}
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {

        // Obtém referência à entidade pelo ID
        ClienteEntity clienteEntity = clienteRepository.getReferenceById(id);

        if (clienteEntity != null) {
            // Deleta a entidade do banco
            clienteRepository.delete(clienteEntity);
            // Retorna 204 NO CONTENT indicando sucesso sem corpo
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // Se não encontrar, retorna 404 NOT FOUND
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
