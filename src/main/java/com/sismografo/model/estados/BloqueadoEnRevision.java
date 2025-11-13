package com.sismografo.model.estados;

import java.time.LocalDateTime;

import com.sismografo.model.CambioEstado;
import com.sismografo.model.Estado;
import com.sismografo.model.EventoSismico;
import com.sismografo.model.Empleado;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("BloqueadoEnRevision")
@NoArgsConstructor
public class BloqueadoEnRevision extends Estado {
    
    public BloqueadoEnRevision(String nombre){
        super(nombre);
    }


    @Override
    public void confirmarEvento(EventoSismico evento, LocalDateTime fechaHoraFin, Empleado empleado){
        CambioEstado ceActual = buscarCEActual(evento);

        ceActual.setFechaHoraFin(fechaHoraFin);

        Estado nuevoEstado = crearEstado("Confirmar");

        CambioEstado nuevoCE = crearCE(fechaHoraFin, nuevoEstado, evento, empleado);

        evento.setEstadoActual(nuevoEstado);
        evento.agregarCambioEstado(nuevoCE);
    }

    @Override
    public void rechazarEvento(EventoSismico evento, LocalDateTime fechaHoraFin, Empleado empleado){
        CambioEstado ceActual = buscarCEActual(evento);
      
        ceActual.setFechaHoraFin(fechaHoraFin);

        Estado nuevoEstado = crearEstado("Rechazar");

        CambioEstado nuevoCE = crearCE(fechaHoraFin, nuevoEstado, evento , empleado);
       
        evento.setEstadoActual(nuevoEstado);
        evento.agregarCambioEstado(nuevoCE);
        
    }

    @Override
    public void solicitarRevisionExperto(EventoSismico evento, LocalDateTime fechaHoraFin,Empleado empleado){
        CambioEstado ceActual = buscarCEActual(evento);
      
        ceActual.setFechaHoraFin(fechaHoraFin);

        Estado nuevoEstado = crearEstado("Revision");

        CambioEstado nuevoCE = crearCE(fechaHoraFin, nuevoEstado, evento , empleado);
       
        evento.setEstadoActual(nuevoEstado);
        evento.agregarCambioEstado(nuevoCE);
    }

    public Estado crearEstado(String opc){

        if("Confirmar".equals(opc)){
            return new Confirmado("Confirmado");
        }else if ("Rechazar".equals(opc)){
            return new Rechazado("Rechazado");
        }
        
        return new RevisionAExperto("Solicitar revision a experto");
        
    }

}
