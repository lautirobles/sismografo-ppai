package com.sismografo.model;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "evento_sismico")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlcanceSismico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;
}
