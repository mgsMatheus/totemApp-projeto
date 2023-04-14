package br.com.fiap.saude.service;

import br.com.fiap.saude.model.PacienteModel;
import br.com.fiap.saude.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteModel cadastrar(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    /*public boolean existsByCpf(String cpf) {
        return pacienteRepository.extistsByCpf(cpf);
    }*/

}
