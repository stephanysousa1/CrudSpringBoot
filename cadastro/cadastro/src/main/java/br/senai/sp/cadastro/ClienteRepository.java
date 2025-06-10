package br.senai.sp.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository  // Indica que esta interface é um componente de acesso a dados (DAO)
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // JpaRepository já fornece métodos CRUD prontos:
    // - save(entity): cria ou atualiza uma entidade
    // - findById(id): busca uma entidade por ID, retornando Optional
    // - findAll(): retorna todas as entidades
    // - delete(entity): deleta a entidade
    // - deleteById(id): deleta por ID

}

