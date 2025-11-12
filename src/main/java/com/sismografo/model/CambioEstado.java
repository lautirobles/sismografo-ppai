package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "cambio_estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private Empleado empleado;


    // Estado al que se cambió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado",referencedColumnName = "id")
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_sismico", referencedColumnName = "id")
    private EventoSismico eventoSismico;

    public  CambioEstado(LocalDateTime fechaHoraInicio, Estado estado , EventoSismico evento){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.eventoSismico = evento;
    }

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado, Empleado empleado, EventoSismico eventoSismico){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.empleado = empleado;
        this.eventoSismico = eventoSismico;
    }

    public boolean sosActual(){
    return fechaHoraFin == null;
    }

}