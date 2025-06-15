package br.senai.sp.cadastro;

import org.springframework.data.jpa.domain.Specification;
import br.senai.sp.cadastro.ClienteEntity;

public class ClienteSpecification {

    public static Specification<ClienteEntity> nomeLike(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isEmpty()) return null;
            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    public static Specification<ClienteEntity> cpfLike(String cpf) {
        return (root, query, cb) -> {
            if (cpf == null || cpf.isEmpty()) return null;
            return cb.like(root.get("cpf"), "%" + cpf + "%");
        };
    }

    public static Specification<ClienteEntity> cepLike(String cep) {
        return (root, query, cb) -> {
            if (cep == null || cep.isEmpty()) return null;
            return cb.like(root.get("cep"), "%" + cep + "%");
        };
    }

    public static Specification<ClienteEntity> emailLike(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isEmpty()) return null;
            return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        };
    }
}