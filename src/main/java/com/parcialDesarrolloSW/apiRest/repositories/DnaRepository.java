package com.parcialDesarrolloSW.apiRest.repositories;

import com.parcialDesarrolloSW.apiRest.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna,Long> {

}
