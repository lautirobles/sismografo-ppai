package com.sismografo.model.estados;

import java.time.LocalDateTime;

import com.sismografo.model.CambioEstado;
import com.sismografo.model.Estado;
import com.sismografo.model.EventoSismico;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("AutoDetectado")
public class AutoDetectado extends Estado {
    

    public boolean esAutoDetectado(){
        return true;
    }

    public void bloquearEvento(EventoSismico evento, LocalDateTime fechaHoraFin){
        CambioEstado ceActual = buscarCEActual(evento);
        ceActual.setFechaHoraFin(fechaHoraFin);

        CambioEstado nuevoCE = crearCE(fechaHoraFin, this);

        Estado nuevoEstado = crearEstado();

        evento.setEstadoActual(nuevoEstado);
        evento.agregarCambioEstado(nuevoCE);
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

}
