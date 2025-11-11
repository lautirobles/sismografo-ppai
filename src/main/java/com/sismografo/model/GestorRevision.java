package com.sismografo.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class GestorRevision {
    
    private Sesion sesion;

    private Set<EventoSismico> eventos;

    private EventoSismico eventoSelec;

    private LocalDateTime fechaHoraActual;

    private List<String> datosSismicosEventoSelec;

    private String[] opciones = {"Confirmar", "Rechazar", "Solicitar revision a experto"};

    private boolean modifSeleccionada;

    private String accionSeleccionada;

    private Empleado empleado;

    private boolean visualizarMapa;

    private Set<Sismografo> sismografos;

    public GestorRevision(Sesion sesion, Set<EventoSismico> eventos, Set<Sismografo> sismografos){
        this.sesion = sesion;
        this.eventos = eventos;
        this.sismografos = sismografos;
    }

    // public Set<EventoSismico> buscarEventosNorevisados(){
    //     this.eventos.stream()
    //     .filter(e -> e.esAutoDetectado())
    //     .map(e -> e.obtenerDatosEvento())
        
    // }
}
