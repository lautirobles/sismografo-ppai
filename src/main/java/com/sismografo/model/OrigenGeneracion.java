package com.sismografo.model;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "origen_generacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrigenGeneracion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;
}
