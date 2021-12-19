package com.trianaTourist.cynthiaLab.dto.converter;

import com.trianaTourist.cynthiaLab.dto.dtos.POIDto;
import com.trianaTourist.cynthiaLab.model.POI;
import org.springframework.stereotype.Component;

@Component
public class POIDtoConverter {

    public POI poiDtoToPoi(POIDto poiDto){
        return POI.builder()
                .categoria(poiDto.getCategoria())
                .coverPhoto(poiDto.getCoverPhoto())
                .id(poiDto.getId())
                .date(poiDto.getDate())
                .description(poiDto.getDescription())
                .location(poiDto.getLocation())
                .name(poiDto.getName())
                .photo2(poiDto.getPhoto2())
                .photo3(poiDto.getPhoto3())
                .build();
    }
}
