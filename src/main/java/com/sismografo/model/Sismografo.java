package com.sismografo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "sismografo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sismografo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identificadorSismografo;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estacion_id",referencedColumnName = "id")
    private EstacionSismologica estacionSismologica;

    



    @OneToMany(mappedBy = "sismografo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SerieTemporal> seriesTemporales;

   
}