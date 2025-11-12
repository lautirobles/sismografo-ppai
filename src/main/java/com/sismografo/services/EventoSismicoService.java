package com.sismografo.services;

import org.springframework.stereotype.Service;



import com.sismografo.dto.DatosSismosDto;
import com.sismografo.model.EventoSismico;


import lombok.*;



@Service
@RequiredArgsConstructor
public class EventoSismicoService {

    public DatosSismosDto buscarDatosSismicos(EventoSismico evento){
        String alcance = evento.getAlcanceSismico().getNombre();
        String clasificacion = evento.getClasificacionSismo().getNombre();
        String origen = evento.getOrigenGeneracion().getNombre();

        return new DatosSismosDto(alcance, origen, clasificacion);
    }
    
}
