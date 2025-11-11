package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.EventoSismico;

@Repository
public interface EventoSismicoRepository extends JpaRepository<EventoSismico, Long> {
    
}
