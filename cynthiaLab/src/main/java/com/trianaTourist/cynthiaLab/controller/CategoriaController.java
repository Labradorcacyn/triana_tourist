package com.trianaTourist.cynthiaLab.controller;

import com.trianaTourist.cynthiaLab.dtos.categoriaDto.CategoriaDto;
import com.trianaTourist.cynthiaLab.model.Categoria;
import com.trianaTourist.cynthiaLab.service.CategoriaService;
import com.trianaTourist.cynthiaLab.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final POIService poiService;

    @GetMapping("/{id}")
    public Categoria findOne(@PathVariable Long id){
        return categoriaService.findACategory(id);
    }

    @GetMapping("/")
    public List<Categoria> findAll(){
        return categoriaService.findAllCategories();
    }

    @PostMapping("/")
    public Categoria crearCategoria(@Valid @RequestBody CategoriaDto categoriaDto){
        return categoriaService.saveCategory(categoriaDto);
    }

    @PutMapping("/{id}")
    public Categoria update(@Valid @RequestBody CategoriaDto categoriaDto, @PathVariable Long id){
        return categoriaService.updateCategory(id, categoriaDto);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        poiService.findAll().forEach(p->{
            if(p.getCategoria().equals(categoriaService.findACategory(id))){
                p.setCategoria(null);
                poiService.save(p);
            }
        });
        categoriaService.removeCategory(id);
    }
}
