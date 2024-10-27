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
    public Dna checkDNA(MutantRequestDTO dnaSequence) throws Exception {
       String dnaString = String.join(",",dnaSequence.getDna());
        System.out.println(dnaString);
        boolean isMutant = isMutant(dnaSequence.getDna());
        System.out.println("Es mutante? " + isMutant);
        Dna dna = Dna.builder().dna(dnaString).isMutant(isMutant).build();
         Dna savedDna = dnaRepository.save(dna);
        return savedDna;
    }
    public StatsResponseDTO getStats() throws Exception {
    List<Dna> dnas= dnaRepository.findAll();
    int dnaCount = dnas.size();
    List<Dna> mutantDnas= dnaRepository.findByIsMutantTrue();
    int mutantCount = mutantDnas.size();
    float ratio = dnaCount == 0 ? 0 : mutantCount / dnaCount;
        StatsResponseDTO statsResponseDTO = StatsResponseDTO.builder()
                .countHumanDna(dnaCount)
                .countMutantDna(mutantCount)
                .ratio(ratio)
                .build();
    return statsResponseDTO;
    }

    public static boolean isMutant(String[] dna) {
        // filas
        for (int i = 0; i < dna.length; i++) {
            String fila = dna[i];
            int counter = 0;
            for (int j = 0; j <= fila.length() - 2; j++) {
                if (fila.charAt(j) == fila.charAt(j + 1)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 3) return true;
            }
        }
        // columnas
        for (int j = 0; j < dna[0].length(); j++) {
            int counter = 0;
            for (int i = 0; i <= dna.length - 2; i++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j)) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 3) return true;
            }
        }
        // diagonales
        for (int i = 0; i <= dna.length - 4; i++) {
            if (hasDiagonalMutation(dna, i, 0, 1)) return true;
            if (hasDiagonalMutation(dna, 0, i, 1)) return true;
            if (hasDiagonalMutation(dna, i, dna.length - 1, -1)) return true;
            if (hasDiagonalMutation(dna, 0, dna.length - 1 - i, -1)) return true;
        }
        return false;
    }
    private static boolean hasDiagonalMutation(String[] dna, int startRow, int startCol, int colIncrement) {
        int counter = 0;
        char actualChar = dna[startRow].charAt(startCol);
        int row = startRow + 1;
        int col = startCol + colIncrement;
        while (row >= 0 && row < dna.length && col >= 0 && col < dna.length) {
            if (dna[row].charAt(col) == actualChar) {
                counter++;
                if (counter == 3) return true;
            } else {
                counter = 0;
                actualChar = dna[row].charAt(col);
            }
            row = row + 1;
            col = col + colIncrement;
        }
        return false;
    }
}
