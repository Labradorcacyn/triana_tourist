package com.trianaTourist.cynthiaLab.dtos.poiDtos;

import com.trianaTourist.cynthiaLab.model.POI;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {

    public POI poiDtoToPoi(POIDto poiDto){
        return POI.builder()
                .categoria(poiDto.getCategoria())
                .coverPhoto(poiDto.getCoverPhoto())
                .date(poiDto.getDate())
                .description(poiDto.getDescription())
                .location(poiDto.getLocation())
                .name(poiDto.getName())
                .photo2(poiDto.getPhoto2())
                .photo3(poiDto.getPhoto3())
                .build();
    }
    
    public String dtoPostCategoriatoString(DtoPostCategoria dtoPostCategoria){
        return dtoPostCategoria.getCategoria();
    }
}
