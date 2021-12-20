package com.trianaTourist.cynthiaLab.dtos.poiDtos;

import com.trianaTourist.cynthiaLab.error.excpciones.SingleEntityNotFoundException;
import com.trianaTourist.cynthiaLab.model.Categoria;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.repo.CategoriaRepository;
import com.trianaTourist.cynthiaLab.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {

    @Autowired
    private CategoriaService categoriaService;

    public POI poiDtoToPoi(POIDto poiDto){
        return POI.builder()
                .categoria(categoriaService.findACategory(poiDto.getCategoria()))
                .coverPhoto(poiDto.getCoverPhoto())
                .date(poiDto.getDate())
                .description(poiDto.getDescription())
                .location(poiDto.getLocation())
                .name(poiDto.getName())
                .photo2(poiDto.getPhoto2())
                .photo3(poiDto.getPhoto3())
                .build();
    }
}
