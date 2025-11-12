package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String apellido;
    private String nombre;
    private String mail;
    private String telefono;

}