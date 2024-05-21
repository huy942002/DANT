package com.model.rest.controller;

import com.model.entities.Dimension;
import com.model.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/dimension")
public class DimensionRestController {
    @Autowired
    DimensionService dimensionService;

    @GetMapping
    public List<Dimension> getAll(){
        return dimensionService.findAll();
    }

    @PostMapping
    public Dimension createDimension(@RequestBody Dimension dimension){
        return dimensionService.create(dimension);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        dimensionService.delete(id);
    }
}
