package com.trianaTourist.cynthiaLab.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class POI {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String location;

    private String description;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private String coverPhoto;

    private String photo2;

    private String photo3;
}
