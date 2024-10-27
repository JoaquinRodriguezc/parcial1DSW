package com.parcialDesarrolloSW.apiRest.controllers;

import com.parcialDesarrolloSW.apiRest.dto.MutantRequestDTO;
import com.parcialDesarrolloSW.apiRest.entities.Dna;
import com.parcialDesarrolloSW.apiRest.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class DnaController {
    @Autowired
    protected DnaService servicio;
    @PostMapping("/mutant")
    public ResponseEntity<?> isMutant(@RequestBody() MutantRequestDTO dnaSequence) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.isMutant(dnaSequence));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }


}
