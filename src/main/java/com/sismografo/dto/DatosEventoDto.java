package com.sismografo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DatosEventoDto {
    private Long id;
    private LocalDateTime fechaHoraOcurrencia;
    private BigDecimal latitudEpicentro;
    private BigDecimal longitudEpicentro;
    private BigDecimal latitudHipocentro;
    private BigDecimal longitudHipocentro;
    private float valorMagnitud;
}
