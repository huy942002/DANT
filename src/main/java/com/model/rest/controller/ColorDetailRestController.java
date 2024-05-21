package com.model.rest.controller;

import com.model.entities.ColorDetail;
import com.model.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/colordetail")
public class ColorDetailRestController {

    @Autowired
    ColorDetailService colorDetailService;

    @GetMapping("{id}")
    public List<ColorDetail> colorDetailList(@PathVariable Integer id){
        return colorDetailService.findByProductId(id);
    }

    @PostMapping
    public ColorDetail colorDetail(@RequestBody ColorDetail colorDetail){
        return colorDetailService.create(colorDetail);
    }

    @DeleteMapping("{id}")
    public void Delete_colorDetail(@PathVariable Integer id){
        colorDetailService.delete(id);
    }
}
