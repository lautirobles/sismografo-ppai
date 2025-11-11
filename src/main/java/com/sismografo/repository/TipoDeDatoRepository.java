package com.sismografo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sismografo.model.TipoDeDato;

@Repository
public interface TipoDeDatoRepository extends JpaRepository<TipoDeDato, Long> {
}
