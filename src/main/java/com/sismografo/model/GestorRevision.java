package com.sismografo.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.sismografo.dto.DatosSismosDto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@Component
@NoArgsConstructor
public class GestorRevision {
    
    private Sesion sesion;

    private List<EventoSismico> eventos;

    private EventoSismico eventoSelec;

    private LocalDateTime fechaHoraActual;

    private DatosSismosDto datosSismicosEventoSelec;

    private String[] opciones = {"Confirmar", "Rechazar", "Solicitar revision a experto"};

    private boolean modifSeleccionada;

    private String accionSeleccionada;

    private String empleado;

    private boolean visualizarMapa;

    private Set<Sismografo> sismografos;

    public GestorRevision(Sesion sesion, List<EventoSismico> eventos, Set<Sismografo> sismografos){
        this.sesion = sesion;
        this.eventos = eventos;
        this.sismografos = sismografos;
    }

  public void bloquearEvSismico(){
    eventoSelec.bloquearEvSismico(this.fechaHoraActual);
    System.out.println("Evento bloqueado en estado: " );
    
  }

  public void obtenerFechaYHoraActual(){
    this.fechaHoraActual = LocalDateTime.now();
  }

  public void tomarSeleccion(EventoSismico evento){
    this.eventoSelec = evento;
  }


  
}
