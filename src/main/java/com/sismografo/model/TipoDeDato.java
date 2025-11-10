package com.sismografo.model;

import lombok.*;


import java.math.BigDecimal;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tipo_de_dato")
public class TipoDeDato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denominacion;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "valor_umbral")
    private BigDecimal  valorUmbral;
    
}
