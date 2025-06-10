package br.senai.sp.cadastro;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// simplificando com lombok e com anotaçoes:
@Getter
@Setter
@AllArgsConstructor // simplifica o construtor
// remover construtor, setters e getters apos aplicar anotacoes
public class Cliente {

    private Long id;
    private String nome;
    private String email;
}
