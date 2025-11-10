package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private Boolean esAutoDetectado;
    private Boolean esAltaDefinitiva;

    // Relación One-to-Many con CambioEstado (como estado actual)
    @OneToMany(mappedBy = "estadoActual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CambioEstado> origenCambios;

    // Relación One-to-Many con Empleado
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleadosEnEsteEstado;
}