package br.com.fiap.saude.service;

import br.com.fiap.saude.model.PacienteModel;
import br.com.fiap.saude.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {


    final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteModel cadastrar(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    public List<PacienteModel> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<PacienteModel> findById(UUID id) {
        return pacienteRepository.findById(id);
    }

    /*public boolean validacao(String cpf) {
        return pacienteRepository.extistsByCpf(cpf);
    }*/

}
