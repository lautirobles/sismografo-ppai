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
import com.sismografo.repositories.EventoSismicoRepositoryImpl;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GestorRevisionService {
    
    private final EventoSismicoRepositoryImpl eventoSismicoRepository;
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

    // aca falta ver como hacemos para traer los datos del front, de cual evento se selecciona !!!

    // CREO que falta cargar el evento seleccionado como atributo para la entidad del gestor
    // funcion que bloquea el evento que se selecciona
    public void bloquearEvento(){
        EventoSismicoDto eventoDto = gestor.getEventoSelec();

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        gestor.setFechaHoraActual(fechaHoraActual);

        // recuperamos la entidad desde el DTO
        EventoSismico eventoSelec = eventoSismicoRepository.findById(eventoDto.getId())
            .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        // llamamos al evento para que delegue en el estado (no se si hacerlo en la clase o el service)
        eventoSelec.bloquearEvSismico(fechaHoraActual);

    }

}
