package com.model.rest.controller;

import com.model.entities.MaterialCategory;
import com.model.service.MaterialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/materialCategory")
public class MaterialCategoryRestController {
    @Autowired
    MaterialCategoryService materialCategoryService;

    @GetMapping
    public List<MaterialCategory> getAll(){
        return materialCategoryService.findAll();
    }

    @PostMapping
    public MaterialCategory createMaterialCategory(@RequestBody MaterialCategory materialCategory){
        return materialCategoryService.create(materialCategory);
    }
}
