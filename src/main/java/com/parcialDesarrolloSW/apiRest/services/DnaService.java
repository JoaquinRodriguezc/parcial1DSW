package com.parcialDesarrolloSW.apiRest.services;

import com.parcialDesarrolloSW.apiRest.entities.Dna;
import com.parcialDesarrolloSW.apiRest.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DnaService {
    @Autowired
    private DnaRepository dnaRepository;
    public Long isMutant(Dna dna) throws Exception {
         Dna savedDna = dnaRepository.save(dna);
        // code for detect mutant DNA
        return savedDna.getId();
    }
    public String getStats() throws Exception {
    // get stats
        return "";
    }


}
