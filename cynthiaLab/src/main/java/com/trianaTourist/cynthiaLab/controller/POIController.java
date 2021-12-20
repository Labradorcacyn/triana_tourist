package com.trianaTourist.cynthiaLab.controller;

import com.trianaTourist.cynthiaLab.dtos.poiDtos.POIDto;
import com.trianaTourist.cynthiaLab.model.POI;
import com.trianaTourist.cynthiaLab.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;

    @GetMapping("/")
    public List<POI> getAll(){
        return poiService.ListaPoi();
    }

    @GetMapping("/{id}")
    public POI getById(@PathVariable Long id){
        return poiService.findOne(id);
    }

    @PostMapping("/")
    public POI crear(@Valid @RequestBody POIDto poiDto){
        return poiService.savePoi(poiDto);
    }

    @PutMapping("/{id}")
    public POI actualizar(@PathVariable Long id, @Valid @RequestBody POIDto poiDto){
        return poiService.put(id, poiDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        poiService.remove(id);
    }
}