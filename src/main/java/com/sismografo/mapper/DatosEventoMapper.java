package com.sismografo.mapper;

import com.sismografo.model.EventoSismico;
import com.sismografo.dto.DatosEventoDto;
import java.util.List;
import java.util.stream.Collectors;

public class DatosEventoMapper {
    
    public DatosEventoDto toDTO(EventoSismico evento){
        DatosEventoDto dto = new DatosEventoDto();
        dto.setId(evento.getId());
        dto.setFechaHoraOcurrencia(evento.getFechaHoraOcurrencia());
        dto.setLatitudEpicentro(evento.getLatitudEpicentro());
        dto.setLongitudEpicentro(evento.getLongitudEpicentro());
        dto.setLatitudHipocentro(evento.getLatitudHipocentro());
        dto.setLongitudHipocentro(evento.getLongitudHipocentro());
        dto.setValorMagnitud(evento.getValorMagnitud());
        return dto;
    }

    public List<DatosEventoDto> toDTOList(List<EventoSismico> eventos){
        return eventos.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}
