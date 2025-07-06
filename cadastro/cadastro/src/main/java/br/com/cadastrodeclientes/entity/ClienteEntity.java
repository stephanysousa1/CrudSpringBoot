package br.com.cadastrodeclientes.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@NoArgsConstructor          // Construtor vazio, necessário para JPA
@AllArgsConstructor         // Construtor com todos os campos
@Builder                   // Gera o builder baseado no construtor AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cep;

    // metodo para calcular idade baseada na data de nascimento
    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

}

