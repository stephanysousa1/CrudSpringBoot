package br.senai.sp.cadastro;

import jakarta.persistence.*;
import lombok.*;
import java.time.Period;
import java.time.LocalDate;

@Setter
@Getter
public class ClienteEntity {

    private Long id;

    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String cep;

    // método para calcular a idade baseado na data de nascimento

    public int getIdade() {
        if (this.dataNascimento == null) return 0;
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

}

