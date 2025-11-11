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

    // Relación One-to-Many con CambioEstado (como estado actual)
    @OneToMany(mappedBy = "estadoActual", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CambioEstado> origenCambios;

    // Relación One-to-Many con Empleado
    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empleado> empleadosEnEsteEstado;

    public void rechazarEvento(){
        System.out.println("Evento Rechazado en el estado: " + this.nombre);
    }

    public void confirmarEvento(){
        System.out.println("Evento Confirmado en el estado: " + this.nombre);
    }

    public void cerrarEvento(){
        System.out.println("Evento Cerrado en el estado: " + this.nombre);
    }

    public void anularEvento(){
        System.out.println("Evento Anulado en el estado: " + this.nombre);
    }

    public void bloquearEvento(){
        System.out.println("Evento Bloqueado en el estado: " + this.nombre);
    }

    public void registrarAutoConfirmado(){
        System.out.println("Evento AutoConfirmado en el estado: " + this.nombre);
    }

    public void registrarAutoDetectado(){
        System.out.println("Evento AutoDetectado en el estado: " + this.nombre);
    }

    public void registrarNoRevision(){
        System.out.println("Evento No revisado en el estado: " + this.nombre);
    }

    public void asignarRevisionExperto(){
        System.out.println("Evento Revisado por experto en el estado: " + this.nombre);
    }

    public void registrarCierreVentanaTemporal(){
        System.out.println("Evento con cierre de ventana temporal en el estado: " + this.nombre);
    }

    
}