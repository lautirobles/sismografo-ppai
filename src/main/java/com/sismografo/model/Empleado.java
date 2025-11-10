package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {

    // El ID se hereda de Usuario

    private String mail;
    private String telefono;

    // Relación Many-to-One con Estado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id")
    private Estado estado;
}