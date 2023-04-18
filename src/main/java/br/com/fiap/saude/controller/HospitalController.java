package br.com.fiap.saude.controller;

import br.com.fiap.saude.dtos.HospitalDto;
import br.com.fiap.saude.model.HospitalModel;
import br.com.fiap.saude.service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarHospital(@RequestBody @Valid HospitalDto hospitalDto) {

        HospitalModel hospitalModel = new HospitalModel();
        BeanUtils.copyProperties(hospitalDto, hospitalModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalService.cadastrar(hospitalModel));
    }

    @GetMapping
    public ResponseEntity<List<HospitalModel>> getMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(hospitalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getHospitalByID(@PathVariable(value = "id") UUID id) {
        Optional<HospitalModel> hospitalModelOptional = hospitalService.findById(id);
        if (!hospitalModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(hospitalModelOptional.get());
    }
}
