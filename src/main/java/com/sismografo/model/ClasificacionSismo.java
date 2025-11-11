package com.sismografo.model;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "clasificacion_sismo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasificacionSismo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "km_profundidad_desde")
    private int kmProfundidadDesde;

    @JoinColumn(name = "km_profundidad_hasta")
    private int kmProfundidadHasta;

    private String nombre;
}
