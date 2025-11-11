package com.sismografo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.SerieTemporal;

@Repository
public interface SerieTemporalRepository extends JpaRepository<SerieTemporal, Long> {
}
