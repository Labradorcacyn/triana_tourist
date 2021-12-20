package com.trianaTourist.cynthiaLab.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
