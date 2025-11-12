package com.sismografo.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModificacionDto {

    private String alcance;
    private String origen;
    private Long id;
    private Float magnitud;
    
}
