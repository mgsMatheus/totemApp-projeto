package br.com.fiap.saude.controller;

import br.com.fiap.saude.dtos.PacienteDto;
import br.com.fiap.saude.model.PacienteModel;
import br.com.fiap.saude.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto){
      /*  if (pacienteService.existsByCpf(pacienteDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Cpf já cadastrado!");
        }*/

        PacienteModel pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastrar(pacienteModel));
    }
}
