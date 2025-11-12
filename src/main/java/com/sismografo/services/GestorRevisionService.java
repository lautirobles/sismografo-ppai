package com.sismografo.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sismografo.dto.EventoSismicoDto;
import com.sismografo.mapper.EventoSismicoMapper; 
import com.sismografo.model.EventoSismico;
import com.sismografo.model.GestorRevision;
import com.sismografo.repositories.EventoSismicoRepository;
import com.sismografo.repositories.CambioEstadoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GestorRevisionService {
    
    private final EventoSismicoRepository eventoSismicoRepository;
    private final CambioEstadoRepository cambioEstadoRepository;
    private final EventoSismicoMapper mapper;
    private final GestorRevision gestor;

    

    // CREO que hay que guardar los eventos en el atributo eventos del gestor, no se si hace falta ahora que estamos sacando los datos de la base

    // busca los eventos que todavia no fueron revisados
    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        List<EventoSismico> eventos = eventoSismicoRepository.findAll().stream()
        .filter(e -> e.esAutoDetectado())
        .collect(Collectors.toList());

        eventos = ordenarEventos(eventos);
        gestor.setEventos(eventos);
        return mapper.toDTOList(eventos);
    }

    // funcion que ordena los eventos de acuerdo a la ocurrencia (los mas recientes primero)
    public List<EventoSismico> ordenarEventos(List<EventoSismico> eventos){
        return eventos.stream()
            .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia).reversed())
            .collect(Collectors.toList());
    }

    
    public void bloquearEvento(Long idEvento){
        EventoSismico eventoSelec = eventoSismicoRepository.findById(idEvento)
            .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        gestor.setEventoSelec(eventoSelec);
        gestor.obtenerFechaYHoraActual();
        gestor.bloquearEvSismico();

        eventoSismicoRepository.save(eventoSelec);
        cambioEstadoRepository.saveAll(eventoSelec.getCambioEstado());

    }

    

}