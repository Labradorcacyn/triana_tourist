package com.trianaTourist.cynthiaLab.dto.dtos;

import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueName;

import javax.persistence.ManyToMany;
import java.util.List;

public class RouteDto {
    private Long id;

    @UniqueName(message = "{POI.route.unique}")
    private String name;

    @ManyToMany
    private List<POI> steps;
}
