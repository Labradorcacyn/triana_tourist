package com.trianaTourist.cynthiaLab.service;

import com.trianaTourist.cynthiaLab.dto.converter.POIDtoConverter;
import com.trianaTourist.cynthiaLab.dto.dtos.POIDto;
import com.trianaTourist.cynthiaLab.error.excpciones.ListEntityNotFoundException;
import com.trianaTourist.cynthiaLab.error.excpciones.SingleEntityNotFoundException;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.repo.POIRepository;
import com.trianaTourist.cynthiaLab.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI, Long, POIRepository> {

    private final POIDtoConverter poiDtoConverter;

    private static final List<String> listaCategoria = Arrays.asList("Parque", "Museo", "Tienda");

    public List<POI> ListaPoi() {

        List<POI> lista = super.findAll();

        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else
            return lista;
    }

    public POI findOne(Long id){
        return super.findById(id).orElseThrow(()->
            new SingleEntityNotFoundException(id.toString(),POI.class));
    }

    public POI savePoi(POIDto poidto){
        return super.save(poiDtoConverter.poiDtoToPoi(poidto));
    }

    public void addCategoria(String nombre){
        listaCategoria.add(nombre);
    }
}
