package br.com.fiap.saude.controller;

import br.com.fiap.saude.dtos.MedicoDto;
import br.com.fiap.saude.model.MedicoModel;
import br.com.fiap.saude.model.PacienteModel;
import br.com.fiap.saude.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarMedico(@RequestBody @Valid MedicoDto medicoDto) {

        MedicoModel medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoDto, medicoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.cadastrar(medicoModel));
    }

    @GetMapping
    public ResponseEntity<List<MedicoModel>> getMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMedicoByID(@PathVariable(value = "id") UUID id) {
        Optional<MedicoModel> medicoModelOptional = medicoService.findById(id);
        if (!medicoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(medicoModelOptional.get());
    }
}
//
//    @PutMapping("/{id}")
//    public ResponseEntity<MedicoModel> atualizarMedico(@PathVariable Long id, @RequestBody MedicoModel medicoAtualizado) {
//        Optional<MedicoModel> medicoExistente = medicoRepository.findById(id);
//        if (medicoExistente.isPresent()) {
//            MedicoModel medico = medicoExistente.get();
//            medico.setNome(medicoAtualizado.getNome());
//            medico.setCrm(medicoAtualizado.getCrm());
//            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
//            medicoRepository.save(medico);
//            return ResponseEntity.ok(medico);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
//        Optional<MedicoModel> medico = medicoRepository.findById(id);
//        if (medico.isPresent()) {
//            medicoRepository.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
