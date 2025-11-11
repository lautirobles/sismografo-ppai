package com.sismografo.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.sismografo.repositories.EventoSismicoRepositoryImpl;
import com.sismografo.dto.DatosEventoDto;
import com.sismografo.mapper.DatosEventoMapper; 
import com.sismografo.model.EventoSismico;

public class GestorRevisionService {
    
    private final EventoSismicoRepositoryImpl eventoSismicoRepository;
    private final DatosEventoMapper mapper;

    public GestorRevisionService(EventoSismicoRepositoryImpl eventoSismicoRepository){
        this.eventoSismicoRepository = eventoSismicoRepository;
        this.mapper = new DatosEventoMapper();
    }

    // CREO que hay que guardar los eventos en el atributo eventos del gestor, no se si hace falta ahora que estamos sacando los datos de la base

    public List<DatosEventoDto> buscarEventosNoRevisados(){
        List<EventoSismico> eventos = eventoSismicoRepository.findAll().stream()
        .filter(e -> e.esAutoDetectado())
        .collect(Collectors.toList());

        eventos = ordenarEventos(eventos);
        
        return mapper.toDTOList(eventos);
    }

    public List<EventoSismico> ordenarEventos(List<EventoSismico> eventos){
        return eventos.stream()
            .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia).reversed())
            .collect(Collectors.toList());
    }
}
