package com.sismografo.dto;

import java.time.LocalDateTime;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MuestraSismicaDto {
    private LocalDateTime fechaHoraMuestra;
    private List<DetalleMuestraSismicaDto> detalles;
}
