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
import com.sismografo.services.EventoSismicoService;

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

   
    public void bloquearEvento(Long eventoId){
    
        EventoSismico eventoSelec = eventoSismicoService.buscarPorId(eventoId);
        gestor.tomarSeleccion(eventoSelec);
        gestor.obtenerFechaYHoraActual();
        System.out.println("Evento seleccionado: ID=" + eventoSelec.getId() + 
                   ", estado=" + eventoSelec.getEstadoActual().getNombre());
        gestor.bloquearEvSismico();
        System.out.println("Evento seleccionado: ID=" + eventoSelec.getId() + 
                   ", estado=" + eventoSelec.getEstadoActual().getNombre());

        eventoSismicoService.persistirBloqueo(gestor.getEventoSelec(), gestor.getFechaHoraActual());
    }


    // metodo que calcula la fecha y hora actual
    public LocalDateTime obtenerFechaYHoraActual(){
        return LocalDateTime.now();
    }

    // Sindevuelve void nunca va mostrar nada
    public void buscarDatosSismicos(EventoSismico evento){
        // estos son los 3 datos del sismo que seleccionamos, de aca deberian mostrarse en pantalla al front
        DatosSismosDto datosSismicos = eventoSismicoService.buscarDatosSismicos(evento);
        gestor.setDatosSismicosEventoSelec(datosSismicos);
    }


    public void habilitarOpcionVisualizarMapa(){
        
    }

    public void tomarSolicitud(boolean solicitud){
        if(solicitud){
            // aca deberia mostrar el mapa
        }

        habilitarModificacionEvento();
    }

    public void habilitarModificacionEvento(){
        // aca hay que mandarle el evento y recibir un put desde el front con la modificacion
        // igual el flujo del CU dice que no se modifica
        //EventoSismicoDto evento = gestor.getEventoSelec();
        
    }

    public String[] crearOpciones(){
        return gestor.getOpciones();
    }

    public void tomarAccion(String opc){
        DatosSismosDto datosSismicosEv = gestor.getDatosSismicosEventoSelec();
        validarDatos(datosSismicosEv, opc);
        Empleado empleado = buscarEmpleado();

        actualizarEstado(opc, datosSismicosEv, empleado);
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

    public void actualizarEstado(String opc, DatosSismosDto datosSismosEv, Empleado emp){
        LocalDateTime fecha = obtenerFechaYHoraActual();

        
    }

    

}