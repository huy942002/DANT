package com.model.rest.controller;

import com.model.entities.ProductCategory;
import com.model.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/category")
public class categoryRestController {
    @Autowired
    ProductCategoryService categoryService;

    @GetMapping
    public List<ProductCategory>  getALL(){
        return  categoryService.findAll();
    }

    @PostMapping
    public ProductCategory createCategory(@RequestBody ProductCategory category){
        return categoryService.create(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        categoryService.delete(id);
    }
}
