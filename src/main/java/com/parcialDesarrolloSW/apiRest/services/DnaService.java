package com.parcialDesarrolloSW.apiRest.services;

import com.parcialDesarrolloSW.apiRest.dto.MutantRequestDTO;
import com.parcialDesarrolloSW.apiRest.dto.StatsResponseDTO;
import com.parcialDesarrolloSW.apiRest.entities.Dna;
import com.parcialDesarrolloSW.apiRest.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DnaService {
    @Autowired
    private DnaRepository dnaRepository;
    public Long isMutant(MutantRequestDTO dnaSequence) throws Exception {
       String dnaString = String.join(",",dnaSequence.getDna());
        System.out.println(dnaString);
        Dna dna = Dna.builder().dna(dnaString).build();
         Dna savedDna = dnaRepository.save(dna);
        // code for detect mutant DNA
        return savedDna.getId();
    }
    public StatsResponseDTO getStats() throws Exception {
    List<Dna> dnas= dnaRepository.findAll();
    int dnaCount = dnas.size();
    if(dnaCount == 0){
        return StatsResponseDTO.builder()
                .countHumanDna(0)
                .countMutantDna(0)
                .ratio(0)
                .build();
    }
    List<Dna> mutantDnas= dnaRepository.findByIsMutantTrue();
    int mutantCount = mutantDnas.size();
    float ratio = mutantCount / dnaCount;
        StatsResponseDTO statsResponseDTO = StatsResponseDTO.builder()
                .countHumanDna(dnaCount)
                .countMutantDna(mutantCount)
                .ratio(ratio)
                .build();
    return statsResponseDTO;
    }


}
