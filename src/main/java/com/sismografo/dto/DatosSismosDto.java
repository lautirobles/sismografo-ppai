package com.sismografo.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatosSismosDto {
    private String alcance;
    private String origen;
    private String clasificacion;
}
