package br.com.fiap.saude.interfaces;

import br.com.fiap.saude.dtos.ConsultaDto;
import br.com.fiap.saude.model.ConsultaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mappings({
            @Mapping(source = "hospitalid", target = "hospital_id"),
            @Mapping(source = "medicoid", target = "medico_id"),
            @Mapping(source = "dataConsulta", target = "dataHora"),
            @Mapping(source = "pacienteid", target = "paciente_id")
    })

    ConsultaModel toModel(ConsultaDto consultaDto);
    ConsultaMapper INSTANCE = Mappers.getMapper( ConsultaMapper.class );
    ConsultaModel consultaDtoToConsultaModel(ConsultaDto consultaDto);
    ConsultaDto toDto(ConsultaModel consultaModel);
}
