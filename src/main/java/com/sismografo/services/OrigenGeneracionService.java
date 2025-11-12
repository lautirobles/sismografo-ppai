package com.sismografo.services;


import org.springframework.stereotype.Service;




import com.sismografo.repositories.OrigenGeneracionRepository;
import com.sismografo.model.OrigenGeneracion;


import lombok.*;



@Service
@RequiredArgsConstructor
public class OrigenGeneracionService {

    private final OrigenGeneracionRepository origenGeneracionRepository;


    public OrigenGeneracion findByNombre(String nombre){
        return origenGeneracionRepository.findByNombre(nombre);
    }
    
}
