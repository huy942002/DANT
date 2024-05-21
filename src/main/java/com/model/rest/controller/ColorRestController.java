package com.model.rest.controller;

import com.model.entities.Color;
import com.model.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/color")
public class ColorRestController {
    @Autowired
    ColorService colorService;

    @GetMapping
    public List<Color> getAllColors(){
        return colorService.findAll();
    }

    @PostMapping
    public Color createColor(@RequestBody Color color){
        return colorService.create(color);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        colorService.delete(id);
    }
}
