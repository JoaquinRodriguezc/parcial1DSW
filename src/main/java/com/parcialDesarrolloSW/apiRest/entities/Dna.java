package com.parcialDesarrolloSW.apiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Dna")
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
public class Dna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dna")
    private String dna;
    @Column(name = "isMutant",nullable = true)
    private boolean isMutant;

}
