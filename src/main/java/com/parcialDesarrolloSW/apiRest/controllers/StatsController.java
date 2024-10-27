package com.parcialDesarrolloSW.apiRest.controllers;

import com.parcialDesarrolloSW.apiRest.dto.StatsResponseDTO;
import com.parcialDesarrolloSW.apiRest.services.DnaService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final DnaService statsService;

    public StatsController(DnaService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public StatsResponseDTO getStats() throws Exception {
        return statsService.getStats();
    }
}
