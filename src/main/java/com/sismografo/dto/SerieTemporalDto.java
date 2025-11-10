package com.sismografo.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SerieTemporalDto {
    private Long id;
    private LocalDateTime fechaHoraRegistro;
}
