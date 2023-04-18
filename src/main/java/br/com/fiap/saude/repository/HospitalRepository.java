package br.com.fiap.saude.repository;

import br.com.fiap.saude.model.HospitalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface HospitalRepository  extends JpaRepository<HospitalModel, UUID> {

}
