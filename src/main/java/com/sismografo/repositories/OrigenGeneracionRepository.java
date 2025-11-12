package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.OrigenGeneracion;

@Repository
public interface OrigenGeneracionRepository extends JpaRepository<OrigenGeneracion, Long> {

    OrigenGeneracion findByNombre(String nombre);
}
