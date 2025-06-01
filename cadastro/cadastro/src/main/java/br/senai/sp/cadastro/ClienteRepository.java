package br.senai.sp.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    }

