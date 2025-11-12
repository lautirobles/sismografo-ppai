package com.sismografo.services;

// import java.time.LocalDateTime;
// import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sismografo.dto.DatosSismosDto;
import com.sismografo.dto.EventoSismicoDto;
import com.sismografo.dto.ModificacionDto;
import com.sismografo.mapper.EventoSismicoMapper; 
import com.sismografo.model.EventoSismico;
import com.sismografo.model.GestorRevision;
import com.sismografo.model.Sesion;
import com.sismografo.repositories.EventoSismicoRepository;
import java.util.Optional;

import lombok.*;




@Service
@AllArgsConstructor
public class GestorRevisionService {
    
    private final EventoSismicoRepository eventoSismicoRepository;
    private final EventoSismicoMapper mapper;
    private final GestorRevision gestor;
    private final EventoSismicoService eventoSismicoService;
    private final SesionService sesionService;
    private final AlcanceSismicoService alcanceSismicoService;
    private final OrigenGeneracionService origenGeneracionService;
    
    

    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        List<EventoSismico> eventos = eventoSismicoRepository.findAll();
        gestor.setEventos(eventos);
        gestor.buscarEventosNoRevisados();
        return mapper.toDTOList(gestor.getEventos());
    }



   
    public DatosSismosDto bloquearEvento(Long eventoId){
    
        EventoSismico eventoSelec = eventoSismicoService.buscarPorId(eventoId);
        gestor.tomarSeleccion(eventoSelec);
        gestor.obtenerFechaYHoraActual();
        gestor.bloquearEvSismico();
        gestor.buscarDatosSismicos();
        eventoSismicoService.persistirBloqueo(gestor.getEventoSelec(), gestor.getFechaHoraActual());
        return gestor.getDatosSismicosEventoSelec();
    }

    public void habilitarOpcionVisualizarMapa(){
        
    }

    public void tomarSolicitud(boolean solicitud){
        if(solicitud){
            System.out.println("Funcionalidad en construccion! (no)");
        }

        habilitarModificacionEvento();
    }

    public void habilitarModificacionEvento(){
 
        
    }

    public String[] tomarModificacion(boolean modificacion , ModificacionDto eventoDto){
        if(modificacion){
            EventoSismico eventoExistente = eventoSismicoRepository.findById(eventoDto.getId())
                .orElseThrow(() -> new RuntimeException("Evento sísmico no encontrado"));

            if (eventoDto.getMagnitud() != null) {
            eventoExistente.setValorMagnitud(eventoDto.getMagnitud());

            if (eventoDto.getOrigen() != null) {
            var origen = origenGeneracionService.findByNombre(eventoDto.getOrigen());
            eventoExistente.setOrigenGeneracion(origen);
        }

        if (eventoDto.getAlcance() != null) {
            var alcance = alcanceSismicoService.findByNombre(eventoDto.getAlcance());
            eventoExistente.setAlcanceSismico(alcance);
        }

        eventoSismicoRepository.save(eventoExistente);

        System.out.println("Evento sísmico actualizado correctamente.");
        }


        }

        
        return crearOpciones();
    }

    public String[] crearOpciones(){
        return gestor.getOpciones();
    }

    public void tomarAccion(String opc){
       
        gestor.setOpcionSeleccionada(opc);
        gestor.validarDatos();
        Optional<Sesion> sesionOpt = sesionService.findByFechaHoraFin();
        sesionOpt.ifPresent(sesion -> gestor.setSesion(sesion));
        gestor.buscarEmpleado();
        gestor.setEventoSelec(eventoSismicoService.buscarPorId(gestor.getEventoSelec().getId()));
        gestor.actualizarEstado(opc);
        eventoSismicoService.persistirBloqueo(gestor.getEventoSelec(), gestor.getFechaHoraActual());
    }

    

}