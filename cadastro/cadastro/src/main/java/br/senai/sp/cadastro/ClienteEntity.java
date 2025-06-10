package br.senai.sp.cadastro;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor    // Gera um construtor sem argumentos
@Setter
@Getter
@Entity               // Marca esta classe como uma entidade JPA
@Table(name = "clientes")  // Define o nome da tabela no banco de dados
public class ClienteEntity {

    @Id  // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gera o valor automaticamente no banco (auto-incremento)
    private Long id;

    @Column(nullable = false)  // Define a coluna e indica que não pode ser nula
    private String nome;

    @Column(nullable = false)  // Define a coluna e indica que não pode ser nula
    private String email;

}
