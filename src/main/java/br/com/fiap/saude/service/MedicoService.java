package br.com.fiap.saude.service;

import br.com.fiap.saude.model.MedicoModel;
import br.com.fiap.saude.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoService {

    final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public MedicoModel cadastrar(MedicoModel medicoModel) {
        return medicoRepository.save(medicoModel);
    }
    public List<MedicoModel> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<MedicoModel> findById(UUID id) {
        return medicoRepository.findById(id);
    }
}
