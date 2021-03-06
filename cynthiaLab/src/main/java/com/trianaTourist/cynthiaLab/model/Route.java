package com.trianaTourist.cynthiaLab.model;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueName;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class Route {
    @Id
    @GeneratedValue
    private Long id;

    @UniqueName
    private String name;

    @ManyToMany
    private List<POI> steps;

    public void addPOI(POI poi){this.steps.add(poi);}

    public void removePOI(POI poi){this.steps.remove(poi);}
}
