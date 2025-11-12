package com.sismografo.model.estados;

import java.time.LocalDateTime;

import com.sismografo.model.CambioEstado;
import com.sismografo.model.Estado;
import com.sismografo.model.EventoSismico;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("AutoDetectado")
public class AutoDetectado extends Estado {
    
    @Override
    public boolean esAutoDetectado(){
        return true;
    }

    @Override  
    public void bloquearEvento(EventoSismico evento, LocalDateTime fechaHoraFin){
        CambioEstado ceActual = buscarCEActual(evento);
      
        ceActual.setFechaHoraFin(fechaHoraFin);
        
        Estado nuevoEstado = crearEstado();

        CambioEstado nuevoCE = crearCE(fechaHoraFin, nuevoEstado, evento, null);
       
       

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
