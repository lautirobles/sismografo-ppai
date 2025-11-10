package com.sismografo.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoDeDatoDto {
    private Long id;
    private String denominacion;
    private String unidadMedida;
    private BigDecimal valorUmbral;
}
