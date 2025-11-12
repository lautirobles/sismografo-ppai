package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.CambioEstado;

@Repository
public interface CambioEstadoRepository extends JpaRepository<CambioEstado, Long> {
}
