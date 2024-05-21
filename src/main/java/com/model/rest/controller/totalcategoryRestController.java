package com.model.rest.controller;

import com.model.entities.TotalCategory;
import com.model.service.TotalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/totalCategory")
public class totalcategoryRestController {
    @Autowired
    TotalCategoryService totalCategoryService;

    @GetMapping
    public List<TotalCategory> getall(){
        return totalCategoryService.findAll();
    }

    @PostMapping
    public TotalCategory create(@RequestBody TotalCategory totalCategory){
        return totalCategoryService.create(totalCategory);
    }


}
