package com.sismografo.dto;

import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleMuestraSismicaDto {

    private Long id;
    private BigDecimal valor;
    private Long idTipoDeDato;       
    private String unidadMedida;    
    private BigDecimal valorUmbral;  
    private Long idMuestraSismica;   
}
