package com.sismografo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventoSismicoDto {
    private Long id;
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraOcurrencia;
    private BigDecimal latitudEpicentro;
    private BigDecimal longitudEpicentro;
    private BigDecimal latitudHipocentro;
    private BigDecimal longitudHipocentro;
    private Float valorMagnitud;
    private int magnitud;
    private LocalDateTime fechaHoraRevision;
   
    // referencias a otras clases
    private Long serieTemporalId;
    private Long clasificacionSismoId;
    private Long alcanceSismicoId;
    private Long origenGeneracionId;
    private Long estadoActualId;
}
