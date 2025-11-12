package com.sismografo.services;


import org.springframework.stereotype.Service;




import com.sismografo.repositories.SesionRepository;
import com.sismografo.model.Sesion;
import java.util.Optional;

import lombok.*;



@Service
@RequiredArgsConstructor
public class SesionService {

    private final SesionRepository sesionRepository;
    
    public Optional<Sesion> findByFechaHoraFin() {
        return sesionRepository.findByFechaHoraFin();
    }
}
