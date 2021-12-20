package com.trianaTourist.cynthiaLab.dtos.categoriaDto;

import com.trianaTourist.cynthiaLab.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDtoConverter {

    public Categoria categoriaDtoToCategoria(CategoriaDto dto){
        return Categoria.builder()
                .name(dto.getName())
                .build();
    }
}
