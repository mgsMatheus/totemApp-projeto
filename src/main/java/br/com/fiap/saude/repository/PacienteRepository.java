package br.com.fiap.saude.repository;

import br.com.fiap.saude.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, UUID> {
    //boolean extistsByCpf(String cpf);
}
