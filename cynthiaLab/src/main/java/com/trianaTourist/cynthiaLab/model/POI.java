package com.trianaTourist.cynthiaLab.model;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.LocatedValid;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueCategory;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UrlValid;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class POI {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String location;

    private String description;

    private LocalDateTime date;

    private String categoria;

    private String coverPhoto;

    private String photo2;

    private String photo3;
}
