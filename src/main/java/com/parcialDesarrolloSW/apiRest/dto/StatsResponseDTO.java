package com.parcialDesarrolloSW.apiRest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;
@Builder
@Setter
public class StatsResponseDTO {
    @JsonProperty("count_mutant_dna")
    private long countMutantDna;

    @JsonProperty("count_human_dna")
    private long countHumanDna;
    private float ratio;
}
