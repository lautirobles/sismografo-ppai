package com.sismografo.mapper;

import com.sismografo.model.EventoSismico;
import com.sismografo.dto.EventoSismicoDto;
import java.util.List;
import java.util.stream.Collectors;

import com.sismografo.model.EventoSismico;

import org.springframework.stereotype.Component;

@Component
public class EventoSismicoMapper {
    
    public EventoSismicoDto toDTO(EventoSismico evento){
        EventoSismicoDto dto = new EventoSismicoDto();
        dto.setId(evento.getId());
        dto.setFechaHoraOcurrencia(evento.getFechaHoraOcurrencia());
        dto.setLatitudEpicentro(evento.getLatitudEpicentro());
        dto.setLongitudEpicentro(evento.getLongitudEpicentro());
        dto.setLatitudHipocentro(evento.getLatitudHipocentro());
        dto.setLongitudHipocentro(evento.getLongitudHipocentro());
        dto.setValorMagnitud(evento.getValorMagnitud());
        if (evento.getSerieTemporal() != null) {
            dto.setSerieTemporalId(evento.getSerieTemporal().getId());
        }
        if (evento.getClasificacionSismo() != null) {
            dto.setClasificacionSismoId(evento.getClasificacionSismo().getId());
        }
        if (evento.getAlcanceSismico() != null) {
            dto.setAlcanceSismicoId(evento.getAlcanceSismico().getId());
        }
        if (evento.getOrigenGeneracion() != null) {
            dto.setOrigenGeneracionId(evento.getOrigenGeneracion().getId());
        }
        if (evento.getEstadoActual() != null) {
            dto.setEstadoActualId(evento.getEstadoActual().getId());
        }
    
        return dto;
    }

    public List<EventoSismicoDto> toDTOList(List<EventoSismico> eventos){
        return eventos.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public EventoSismico  toEntity(EventoSismicoDto eventoDto){

        EventoSismico entidad = new EventoSismico();

        entidad.setMagnitud(eventoDto.getMagnitud());

        return  entidad;


    }
}
