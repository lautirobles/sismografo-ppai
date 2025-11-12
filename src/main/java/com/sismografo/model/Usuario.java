package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombreUsuario;

    private Empleado empleado;

    // Relación One-to-Many con Sesion
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sesion> sesiones;


    public Empleado conocerEmpleado(){
        return this.empleado;
    }
}