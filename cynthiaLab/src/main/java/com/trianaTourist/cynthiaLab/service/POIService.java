package com.trianaTourist.cynthiaLab.service;

import com.trianaTourist.cynthiaLab.dtos.poiDtos.POIDtoConverter;
import com.trianaTourist.cynthiaLab.dtos.poiDtos.POIDto;
import com.trianaTourist.cynthiaLab.error.excpciones.ListEntityNotFoundException;
import com.trianaTourist.cynthiaLab.error.excpciones.SingleEntityNotFoundException;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.repo.POIRepository;
import com.trianaTourist.cynthiaLab.service.base.BaseService;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI, Long, POIRepository> {

    private final POIDtoConverter poiDtoConverter;
    private final CategoriaService categoriaService;

    private final List<String> listaCategoria = Arrays.asList("Parque", "Museo", "Tienda");

    public List<POI> ListaPoi() {

        List<POI> lista = repositorio.findAll();

        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else
            return lista;
    }

    public POI findOne(Long id){
        return repositorio.findById(id).orElseThrow(()->
            new SingleEntityNotFoundException(id.toString(),POI.class));
    }

    public POI put(Long id, POIDto dto){
        return repositorio.findById(id).map(p->{
            p.setName(dto.getName());
            p.setCategoria(categoriaService.findACategory(dto.getCategoria()));
            p.setCoverPhoto(dto.getCoverPhoto());
            p.setDate(dto.getDate());
            p.setDescription(dto.getDescription());
            p.setPhoto2(dto.getPhoto2());
            p.setPhoto3(dto.getPhoto3());
            p.setLocation(dto.getLocation());
                    repositorio.save(p);
                    return p;
                })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    public POI savePoi(POIDto poidto){return repositorio.save(poiDtoConverter.poiDtoToPoi(poidto));}

    public void remove(Long id){

        repositorio.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));

        if( repositorio.findById(id)!=null){
            repositorio.deleteById(id);
        }
    }
}