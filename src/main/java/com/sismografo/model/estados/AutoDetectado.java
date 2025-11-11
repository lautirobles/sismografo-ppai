package com.sismografo.model.estados;

import java.time.LocalDateTime;

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

        // crearCE(fechaHoraFin, );

    }

    public CambioEstado buscarCEActual(EventoSismico evento){
        return evento.getCambioEstado().stream()
            .filter(c -> c.sosActual())
            .findFirst()
            .orElse(null);
    }

    public Estado crearEstado(){
        return new BloqueadoEnRevision("Bloqueado en revision");
    }

    public void crearCE(LocalDateTime fechaHoraInicio, Estado estado){
        new CambioEstado(fechaHoraInicio, estado);
    }

    
}
