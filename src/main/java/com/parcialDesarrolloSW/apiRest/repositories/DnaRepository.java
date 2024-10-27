package com.parcialDesarrolloSW.apiRest.repositories;

import com.parcialDesarrolloSW.apiRest.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {
    List<Dna> findByIsMutantTrue();
}
