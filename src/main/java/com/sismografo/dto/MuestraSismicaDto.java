package com.sismografo.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MuestraSismicaDto {
    private Long id;
    private LocalDateTime fechaHoraMuestra;
    private Long idSerieTemporal;  
}
