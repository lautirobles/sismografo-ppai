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

    // Relación One-to-Many con SerieTemporal
    @OneToMany(mappedBy = "sismografo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SerieTemporal> seriesTemporales;

    // Otros atributos según el diagrama (coordenadas, etc.)
}