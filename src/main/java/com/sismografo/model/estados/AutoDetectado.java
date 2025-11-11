package com.sismografo.model.estados;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.sismografo.model.CambioEstado;
import com.sismografo.model.Estado;
import com.sismografo.model.EventoSismico;

public class AutoDetectado extends Estado {
    

    public boolean esAutoDetectado(){
        return true;
    }

    public void bloquearEvento(EventoSismico evento, LocalDateTime fechaHoraFin){
        CambioEstado ceActual = buscarCEActual(evento);
        ceActual.setFechaHoraFin(fechaHoraFin);

        crearCE();

    }

    public CambioEstado buscarCEActual(EventoSismico evento){
        return evento.getCambioEstado().stream()
            .filter(c -> c.sosActual())
            .findFirst()
            .orElse(null);
    }

    public void crearCE(){
        new CambioEstado(LocalDateTime fechaHoraInicio);
    }
}
