package br.senai.sp.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository  // Indica que esta interface é um componente de acesso a dados (DAO)
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // JpaRepository já fornece métodos CRUD prontos:


}

