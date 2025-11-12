package com.sismografo.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;



// import com.sismografo.dto.DatosSismosDto;
import com.sismografo.repositories.EventoSismicoRepository;
import com.sismografo.model.CambioEstado;
import com.sismografo.model.Estado;
import com.sismografo.model.EventoSismico;
// import com.sismografo.services.EstadoService;
// import com.sismografo.services.CambioEstadoService;


import lombok.*;



@Service
@RequiredArgsConstructor
public class EventoSismicoService {

    private final EventoSismicoRepository eventoSismicoRepository;
    private final EstadoService estadoService;
    private final CambioEstadoService cambioEstadoService;

    


    public EventoSismico buscarPorId(Long idLong){
        EventoSismico evento = eventoSismicoRepository.findById(idLong)
            .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return evento;
    }

    

    public void persistirBloqueo(EventoSismico evento, LocalDateTime fechaHoraActual) {

        // 1️⃣ Buscar el cambio de estado anterior: el que tiene fechaHoraFin = fechaHoraActual
        CambioEstado ceAnterior = evento.getCambioEstado().stream()
            .filter(ce -> fechaHoraActual.equals(ce.getFechaHoraFin()))
            .findFirst()
            .orElse(null);

        if (ceAnterior != null) {
            cambioEstadoService.guardarCambioEstado(ceAnterior);
        }

        // 2️⃣ Persistir el nuevo estado si no tiene ID
        Estado nuevoEstado = evento.getEstadoActual();
        if (nuevoEstado != null && nuevoEstado.getId() == null) {
            estadoService.guardarEstado(nuevoEstado);
        }

        // 3️⃣ Buscar el nuevo cambio de estado (el que tiene id nulo)
        CambioEstado nuevoCE = evento.getCambioEstado().stream()
            .filter(ce -> ce.getId() == null && ce.getFechaHoraInicio().equals(fechaHoraActual))
            .findFirst()
            .orElse(null);

        if (nuevoCE != null) {
            cambioEstadoService.guardarCambioEstado(nuevoCE);
        }

        // 4️⃣ Finalmente guardar el evento
        eventoSismicoRepository.save(evento);
    }

}
