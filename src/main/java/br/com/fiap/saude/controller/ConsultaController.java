package br.com.fiap.saude.controller;

import br.com.fiap.saude.dtos.ConsultaDto;
import br.com.fiap.saude.model.ConsultaModel;
import br.com.fiap.saude.repository.ConsultaRepository;
import br.com.fiap.saude.service.ConsultaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableSpringDataWebSupport
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    Logger log = LoggerFactory.getLogger(ConsultaController.class);


    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ConsultaModel> cadastrarConsulta(@RequestBody @Valid ConsultaDto consultaDto) {
        ConsultaModel consultaModel = modelMapper.map(consultaDto, ConsultaModel.class);
        consultaModel = consultaRepository.save(consultaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.cadastrar(consultaModel));
    }


    private URI uriConsulta(@NotNull ConsultaModel consulta) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(consulta.getId()).toUri();
    }

    @GetMapping
    public ResponseEntity<List<ConsultaModel>> getConsulta() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.findAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> consultarConsulta(@PathVariable UUID id) {
//        Optional<ConsultaModel> consultaModelOptional = consultaService.findById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(consultaModelOptional.get());
//    }
}



//    @PutMapping("/{id}")
//    public ResponseEntity<ConsultaDto> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody ConsultaDto consultaDto) {
//        consultaDto.setId(id);
//        ConsultaDto consultaAtualizada = consultaService.atualizarConsulta(consultaDto);
//        return ResponseEntity.ok(consultaAtualizada);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> excluirConsulta(@PathVariable Long id) {
//        consultaService.excluirConsulta(id);
//        return ResponseEntity.noContent().build();

