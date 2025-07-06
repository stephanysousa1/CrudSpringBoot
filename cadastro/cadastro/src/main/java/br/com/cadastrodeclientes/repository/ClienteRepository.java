package br.com.cadastrodeclientes.repository;

import br.com.cadastrodeclientes.entity.ClienteEntity;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository  // Indica que esta interface é um componente de acesso a dados (DAO)
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>, JpaSpecificationExecutor<ClienteEntity> {

    boolean existsByCpf(@NotEmpty(message = "CPF é obrigatório") @CPF(message = "CPF inválido") String cpf);
}

