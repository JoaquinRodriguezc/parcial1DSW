package com.parcialDesarrolloSW.apiRest.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Dna")
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
