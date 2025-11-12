package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.Sesion;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
    

    @Query("SELECT s FROM Sesion s WHERE s.fechaHoraFin IS NULL")
    public Optional<Sesion> findByFechaHoraFin();

}
