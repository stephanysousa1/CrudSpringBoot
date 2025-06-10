package br.senai.sp.cadastro;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

// simplificando com lombok com anotaçoes:
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor // simplifica o construtor
public class Cliente {

    private Long id;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "CPF é obrigatório")
    private String cpf;

    @Past (message = "Data Invalida")
    private LocalDate dataNascimento;

    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter DDD seguido de 9 dígitos")
    private String telefone;

    @Email(message = "Email Invalido")
    private String email;

    @Size(max=100, message = "Endereço deve ter no máximo 100 caracteres")
    private String endereco;

    @Pattern(regexp = "\\d{8}")
    private String cep;

}
