package com.sismografo.services;


import org.springframework.stereotype.Service;




import com.sismografo.repositories.AlcanceSismicoRepository;
import com.sismografo.model.AlcanceSismico;


import lombok.*;



@Service
@RequiredArgsConstructor
public class AlcanceSismicoService {


    private final AlcanceSismicoRepository alcanceSismicoRepository;

    public AlcanceSismico findByNombre(String nombre) {
        AlcanceSismico alcance = alcanceSismicoRepository.findByNombre(nombre);
        if (alcance == null) {
            throw new RuntimeException("No se encontró el AlcanceSismico con nombre: " + nombre);
        }
        return alcance;
    }
    
}
