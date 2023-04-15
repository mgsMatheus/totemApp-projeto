package br.com.fiap.saude.controller;

import br.com.fiap.saude.dtos.PacienteDto;
import br.com.fiap.saude.model.PacienteModel;
import br.com.fiap.saude.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto){
        /*if (pacienteService.validacao(pacienteDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Cpf já cadastrado!");
        }*/

        PacienteModel pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastrar(pacienteModel));
    }

    @GetMapping
    public ResponseEntity<List<PacienteModel>> getAllPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id")UUID id) {
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteModelOptional.get());
    }

}
