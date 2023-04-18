package br.com.fiap.saude.service;



import br.com.fiap.saude.model.ConsultaModel;
import br.com.fiap.saude.repository.ConsultaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ConsultaService {

    final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public ConsultaModel cadastrar(ConsultaModel consultaModel) {
        return consultaRepository.save(consultaModel);
    }

    public List<ConsultaModel> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<ConsultaModel> findById(UUID id) {
        return consultaRepository.findById(id);
    }
}