package com.sismografo.dto;

import java.time.LocalDateTime;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SerieTemporalDto {
    private LocalDateTime fechaHoraRegistro;
    private List<MuestraSismicaDto> muestras;
}
