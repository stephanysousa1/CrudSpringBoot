package br.senai.sp.cadastro;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// simplificando com lombok com anotaçoes:
@Getter
@Setter
@AllArgsConstructor // simplifica o construtor
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String cep;

}
