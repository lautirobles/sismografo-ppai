package com.sismografo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.EventoSismico;

@Repository
public interface EventoSismicoRepositoryImpl extends JpaRepository<EventoSismico, Long> {
    
}
