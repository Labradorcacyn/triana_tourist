package com.trianaTourist.cynthiaLab.dtos.routeDtos;

import com.trianaTourist.cynthiaLab.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route routeToRouteDto(RouteDto dto){
        return Route.builder()
                .name(dto.getName())
                .steps(dto.getSteps())
                .build();
    }
}
