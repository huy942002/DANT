package com.model.rest.controller;

import com.model.entities.Material;
import com.model.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/material")
public class MaterialRestController {
    @Autowired
    MaterialService materialService;

    @GetMapping
    public List<Material> getAll(){
        return materialService.findAll();
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material){
        return materialService.create(material);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        materialService.delete(id);
    }
}
