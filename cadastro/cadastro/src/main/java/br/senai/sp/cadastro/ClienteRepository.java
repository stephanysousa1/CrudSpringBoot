package br.senai.sp.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository  // Indica que esta interface é um componente de acesso a dados (DAO)
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>, JpaSpecificationExecutor<ClienteEntity> {
    List<ClienteEntity> findByNomeContainingIgnoreCase(String nome);

    List<ClienteEntity> findByCpfContaining(String cpf);


}

