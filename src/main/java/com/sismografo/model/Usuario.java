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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado_id", referencedColumnName = "id")
    private Empleado empleado;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Sesion> sesiones;


    public Empleado conocerEmpleado(){
        return this.empleado;
    }
}