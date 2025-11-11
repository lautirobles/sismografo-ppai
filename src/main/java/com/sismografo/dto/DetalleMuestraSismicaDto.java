package com.sismografo.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleMuestraSismicaDto {
    private BigDecimal valor;
    private String denominacion;  
}

