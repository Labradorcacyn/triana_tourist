package com.trianaTourist.cynthiaLab.dtos.categoriaDto;

import com.trianaTourist.cynthiaLab.validacion.anotaciones.UniqueCategory;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class CategoriaDto {

    @UniqueCategory
    private String name;
}
