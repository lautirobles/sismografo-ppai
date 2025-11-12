package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "cambio_estado")
@Data
@NoArgsConstructor
public class CambioEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @JoinColumn(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    // Estado al que se cambió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private Estado estado;

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public CambioEstado(LocalDateTime fechaHoraInicio, Estado estado, Empleado empleado){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
        this.empleado = empleado;
    }

    public boolean sosActual(){
        if(fechaHoraFin != null){
            return true;
        }
        return false;
    }
}