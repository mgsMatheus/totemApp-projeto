package br.com.fiap.saude.service;

import br.com.fiap.saude.model.MedicoModel;
import br.com.fiap.saude.repository.MedicoRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public MedicoModel cadastrar(MedicoModel medicoModel) {
        return medicoRepository.save(medicoModel);
    }
}
