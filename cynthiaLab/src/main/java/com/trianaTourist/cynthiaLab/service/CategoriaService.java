package com.trianaTourist.cynthiaLab.service;

import com.trianaTourist.cynthiaLab.dtos.categoriaDto.CategoriaDto;
import com.trianaTourist.cynthiaLab.dtos.categoriaDto.CategoriaDtoConverter;
import com.trianaTourist.cynthiaLab.error.excpciones.ListEntityNotFoundException;
import com.trianaTourist.cynthiaLab.error.excpciones.SingleEntityNotFoundException;
import com.trianaTourist.cynthiaLab.model.Categoria;
import com.trianaTourist.cynthiaLab.repo.CategoriaRepository;
import com.trianaTourist.cynthiaLab.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService extends BaseService<Categoria, Long, CategoriaRepository> {

    private final CategoriaDtoConverter categoriaDtoConverter;

    public Categoria findACategory(Long id){
        return repositorio.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(),Categoria.class));
    }

    public List<Categoria> findAllCategories(){
        List<Categoria> lista = repositorio.findAll();
        if(lista.isEmpty()){
            throw new ListEntityNotFoundException(Categoria.class);
        }else
            return lista;
    }

    public void removeCategory(Long id){
        repositorio.findById(id).orElseThrow(()->
                new SingleEntityNotFoundException(id.toString(), Categoria.class));
        if(repositorio.findById(id)!=null)
            repositorio.deleteById(id);
    }

    public Categoria saveCategory(CategoriaDto categoriaDto){
        return repositorio.save(categoriaDtoConverter.categoriaDtoToCategoria(categoriaDto));
    }

    public Categoria updateCategory(Long id, CategoriaDto categoriaDto){
        return repositorio.findById(id).map(c->{
            c.setName(categoriaDto.getName());
            repositorio.save(c);
            return c;
        }).orElseThrow(()-> new SingleEntityNotFoundException(id.toString(), Categoria.class));
    }

}
