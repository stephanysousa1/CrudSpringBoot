package br.senai.sp.cadastro;

import lombok.*;

import java.time.LocalDate;

// simplificando com lombok com anotaçoes:
@Getter
@Setter
@NoArgsConstructor
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
