package com.sismografo.services;


import org.springframework.stereotype.Service;




import com.sismografo.repositories.EstadoRepository;
import com.sismografo.model.Estado;


import lombok.*;



@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public void guardarEstado(Estado estado){
        estadoRepository.save(estado);
    }
    
}
