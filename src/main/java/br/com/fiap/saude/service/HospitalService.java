package br.com.fiap.saude.service;

import br.com.fiap.saude.model.HospitalModel;
import br.com.fiap.saude.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class HospitalService {

    final HospitalRepository hospitalRepository;
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }
    public HospitalModel cadastrar(HospitalModel hospitalModel) {
        return hospitalRepository.save(hospitalModel);
    }
    public List<HospitalModel> findAll() {
        return hospitalRepository.findAll();
    }

    public Optional<HospitalModel> findById(UUID id) {
        return hospitalRepository.findById(id);
    }
}

