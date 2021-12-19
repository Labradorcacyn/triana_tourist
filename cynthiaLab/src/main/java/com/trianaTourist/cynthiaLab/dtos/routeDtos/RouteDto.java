package com.trianaTourist.cynthiaLab.dtos.routeDtos;

import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueName;
import lombok.*;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class RouteDto {
    private Long id;

    @UniqueName(message = "{POI.route.unique}")
    private String name;

    private List<POI> steps;
}
