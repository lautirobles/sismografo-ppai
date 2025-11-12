package com.sismografo.mapper;

import org.springframework.stereotype.Component;
import com.sismografo.dto.DatosSismosDto;

@Component
public class DatosSismosMapper{

    public DatosSismosDto toDTO(String alcance, String origen, String clasificacion){
        DatosSismosDto dto = new DatosSismosDto();

        dto.setAlcance(alcance);
        dto.setClasificacion(clasificacion);
        dto.setOrigen(origen);
        return dto;
    }
}
