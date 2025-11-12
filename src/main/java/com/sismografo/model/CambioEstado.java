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

    @JoinColumn(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @JoinColumn(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;


    // Estado al que se cambió
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado",referencedColumnName = "id")
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_sismico", referencedColumnName = "id")
    private EventoSismico eventoSismico;

    public  CambioEstado(LocalDateTime fechaHoraInicio, Estado estado){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public boolean sosActual(){
        if(fechaHoraFin != null){
            return true;
        }
        return false;
    }
}