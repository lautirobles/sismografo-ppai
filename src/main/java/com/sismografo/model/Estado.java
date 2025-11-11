package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "estado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private Boolean esAutoDetectado;
    private Boolean esAltaDefinitiva;

   
    @OneToMany(mappedBy = "estadoActual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CambioEstado> origenCambios;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleadosEnEsteEstado;
}