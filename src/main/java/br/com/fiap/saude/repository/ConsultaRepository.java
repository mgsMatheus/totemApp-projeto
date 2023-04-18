package br.com.fiap.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.saude.model.ConsultaModel;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, UUID> {

}
