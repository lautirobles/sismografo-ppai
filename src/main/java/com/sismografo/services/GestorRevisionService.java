package com.sismografo.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sismografo.dto.DatosSismosDto;
import com.sismografo.dto.EventoSismicoDto;
import com.sismografo.mapper.EventoSismicoMapper; 
import com.sismografo.model.EventoSismico;
import com.sismografo.model.GestorRevision;
import com.sismografo.repositories.EventoSismicoRepository;
import com.sismografo.model.Empleado;
// import com.sismografo.services.EventoSismicoService;

import lombok.*;




@Service
@AllArgsConstructor
public class GestorRevisionService {
    
    private final EventoSismicoRepository eventoSismicoRepository;
    private final EventoSismicoMapper mapper;
    private final GestorRevision gestor;
    private final EventoSismicoService eventoSismicoService;
    

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
        // aca hay que mandarle el evento y recibir un put desde el front con la modificacion
        // igual el flujo del CU dice que no se modifica
        //EventoSismicoDto evento = gestor.getEventoSelec();
        
    }

    public void tomarModificacion(boolean modificacion){
        if(modificacion){
            System.out.println("Evento modificado!! (no)");
        }

        crearOpciones();
    }

    public String[] crearOpciones(){
        return gestor.getOpciones();
    }

    public void tomarAccion(String opc){
        DatosSismosDto datosSismicosEv = gestor.getDatosSismicosEventoSelec();
        validarDatos(datosSismicosEv, opc);
        Empleado empleado = buscarEmpleado();

    }

    public boolean validarDatos(DatosSismosDto datosSismicosEv, String opc){
        if(datosSismicosEv.getAlcance() != null && datosSismicosEv.getClasificacion() != null && datosSismicosEv.getOrigen() != null){
            if(opc != null){
                return true;
            }
            System.out.println("No paso la validacion (no se registra la opcion seleccionada`)");
            return false;
        }
        System.out.println("No paso la validacion (datos del sismo incompletos)");
        return false;
    }

    public Empleado buscarEmpleado(){
        return gestor.getSesion().conocerUsuario();
    }


    public LocalDateTime obtenerFechaYHoraActual(){
        return LocalDateTime.now();
    }


    public void rechazarEvento(Long eventoId){
        // REVISAR XQ sino lo buscaba de nuevo en la bd se rompia todo si usaba el que tenia guardado
        gestor.setEventoSelec(eventoSismicoService.buscarPorId(gestor.getEventoSelec().getId()));
        gestor.actualizarEstado();
        eventoSismicoService.persistirBloqueo(gestor.getEventoSelec(), gestor.getFechaHoraActual());

    }

    

}