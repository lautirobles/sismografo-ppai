package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.AlcanceSismico;

@Repository
public interface AlcanceSismicoRepository extends JpaRepository<AlcanceSismico, Long> {

    AlcanceSismico findByNombre(String nombre);
}
