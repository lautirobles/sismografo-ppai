package com.sismografo.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sismografo.dto.DatosSismosDto;

import java.util.Comparator;
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

    private String opcionSeleccionada;

    private Empleado empleado;

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

 public void buscarDatosSismicos(){
        this.datosSismicosEventoSelec = eventoSelec.buscarDatosSismicos();
  }

  public void actualizarEstado(String opc){
    obtenerFechaYHoraActual();
    if(opc == "Confirmar"){
      this.eventoSelec.confirmarEvento(this.fechaHoraActual, this.empleado);
    }else if(opc == "Rechazar"){
      this.eventoSelec.rechazarEvento(this.fechaHoraActual,this.empleado);
    }else if(opc == "Solicitar revision a experto"){
      this.eventoSelec.solicitarRevisionExperto(this.fechaHoraActual, this.empleado);
    }
    
  }

  public List<EventoSismico> ordenarEventos(){
        return this.eventos.stream()
            .sorted(Comparator.comparing(EventoSismico::getFechaHoraOcurrencia).reversed())
            .collect(Collectors.toList());
  }


  public Boolean validarDatos(){
    if (datosSismicosEventoSelec.getAlcance() != null && datosSismicosEventoSelec.getClasificacion() != null && datosSismicosEventoSelec.getOrigen() != null && opcionSeleccionada != null) {
        return true;
    }
    return false;
  }

  public void buscarEmpleado(){
    Empleado empleado = sesion.conocerUsuario();
    this.empleado = empleado;

  }


 
  


}
