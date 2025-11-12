package com.sismografo.services;



import org.springframework.stereotype.Service;




import com.sismografo.repositories.CambioEstadoRepository;
import com.sismografo.model.CambioEstado;


import lombok.*;



@Service
@RequiredArgsConstructor
public class CambioEstadoService {

    private final CambioEstadoRepository cambioEstadoRepository;

    public void guardarCambioEstado(CambioEstado cambioEstado){
        cambioEstadoRepository.save(cambioEstado);
    }
    
}
