package com.sismografo.model;

import lombok.*;


import java.math.BigDecimal;

import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "detalle_muestra_sismica")
public class DetalleMuestraSismica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "tipo_de_dato",referencedColumnName = "id")
    private TipoDeDato tipoDeDato;

    @ManyToOne
    @JoinColumn(name = "muestra_sismica", referencedColumnName = "id")
    private MuestraSismica muestraSismica;

    
}
