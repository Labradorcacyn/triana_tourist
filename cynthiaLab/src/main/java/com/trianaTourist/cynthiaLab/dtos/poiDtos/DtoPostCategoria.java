package com.trianaTourist.cynthiaLab.dtos.poiDtos;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueCategory;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class DtoPostCategoria {

    @UniqueCategory
    private String categoria;
}
