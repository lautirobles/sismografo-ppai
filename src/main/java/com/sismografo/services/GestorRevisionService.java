package com.sismografo.services;

// import java.time.LocalDateTime;
// import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sismografo.dto.DatosSismosDto;
import com.sismografo.dto.EventoSismicoDto;
import com.sismografo.mapper.EventoSismicoMapper; 
import com.sismografo.model.EventoSismico;
import com.sismografo.model.GestorRevision;
import com.sismografo.model.Sesion;
import com.sismografo.repositories.EventoSismicoRepository;
// import com.sismografo.model.Empleado;
// import com.sismografo.services.SesionService;
// import com.sismografo.services.EventoSismicoService;
// import com.sismografo.services.SesionService;
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
    

    public List<EventoSismicoDto> buscarEventosNoRevisados(){
        List<EventoSismico> eventos = eventoSismicoRepository.findAll().stream()
        .filter(e -> e.esAutoDetectado())
        .collect(Collectors.toList());
        gestor.setEventos(eventos);

        gestor.ordenarEventos();
        return mapper.toDTOList(eventos);
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

    public String[] tomarModificacion(boolean modificacion){
        if(modificacion){
            System.out.println("Evento modificado!! (no)");
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
        gestor.actualizarEstado();
        eventoSismicoService.persistirBloqueo(gestor.getEventoSelec(), gestor.getFechaHoraActual());
    }

    

}