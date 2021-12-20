package com.trianaTourist.cynthiaLab.service;

import com.trianaTourist.cynthiaLab.dtos.routeDtos.RouteDto;
import com.trianaTourist.cynthiaLab.dtos.routeDtos.RouteDtoConverter;
import com.trianaTourist.cynthiaLab.error.excpciones.ListEntityNotFoundException;
import com.trianaTourist.cynthiaLab.error.excpciones.POIRouteException;
import com.trianaTourist.cynthiaLab.error.excpciones.SingleEntityNotFoundException;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.model.Route;
import com.trianaTourist.cynthiaLab.repo.RouteRepository;
import com.trianaTourist.cynthiaLab.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, Long, RouteRepository> {

    private final RouteDtoConverter routeDtoConverter;
    private final POIService poiService;

    public List<Route> findAllRutas(){
        List<Route> lista = repositorio.findAll();
        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Route.class);
        }else
            return lista;
    }

    public Route getById(Long id){
        return repositorio.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(),Route.class));
    }

    public Route savePoi(RouteDto routeDto){return repositorio.save(routeDtoConverter.routeToRouteDto(routeDto));}

    public Route put(Long id, RouteDto dto){
        return repositorio.findById(id).map(r->{
                    r.setName(dto.getName());
                    r.setSteps(dto.getSteps());
                    repositorio.save(r);
                    return r;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public void remove(Long id){

        repositorio.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));

        if( repositorio.findById(id)!=null){
            repositorio.deleteById(id);
        }
    }

    public Route addPoi(Long id1, Long id2){
        Route route = repositorio.getById(id1);

        route.getSteps().forEach(p->{if(p.getId().equals(id2)){
            throw new POIRouteException(id2.toString(), POI.class);
        }});
        route.addPOI(poiService.findOne(id2));
        return repositorio.save(route);
    }

    public void deletePoi(Long id1, Long id2) {
        Route route = repositorio.getById(id1);

        if(route == null)
            throw new SingleEntityNotFoundException(id1.toString(), Route.class);

        if (poiService.findOne(id2) != null) {
            route.removePOI(poiService.findOne(id2));
        }
    }
}