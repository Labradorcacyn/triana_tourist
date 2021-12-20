package com.trianaTourist.cynthiaLab.controller;

import com.trianaTourist.cynthiaLab.dtos.routeDtos.RouteDto;
import com.trianaTourist.cynthiaLab.error.excpciones.POIRouteException;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.model.Route;
import com.trianaTourist.cynthiaLab.service.POIService;
import com.trianaTourist.cynthiaLab.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
    private final POIService poiService;

    @GetMapping("/")
    public List<Route> findAll(){
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public Route oneRuta(@PathVariable Long id){
        return routeService.getById(id);
    }

    @PostMapping("/")
    public Route crear(@Valid @RequestBody RouteDto routeDto){
        return routeService.savePoi(routeDto);
    }

    @PutMapping("/{id}")
    public Route actualizar(@PathVariable Long id, @Valid @RequestBody RouteDto routeDto){
        return routeService.put(id, routeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        routeService.remove(id);
    }

    @PostMapping("/{id1}/poi/{id2}")
    public Route addPOIToRoute(@PathVariable Long id1, @PathVariable Long id2) {
        return routeService.addPoi(id1,id2);
    }

    @DeleteMapping("/{id1}/poi/{id2}")
    public void deletePoiOfRoute(@PathVariable Long id1, @PathVariable Long id2){routeService.deletePoi(id1, id2);}

}