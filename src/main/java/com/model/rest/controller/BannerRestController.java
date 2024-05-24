package com.model.rest.controller;

import com.model.entities.Banner;
import com.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/banner")
public class BannerRestController {
    @Autowired
    BannerService bannerService;

    @GetMapping
    public List<Banner> getAll(){
        return bannerService.findAll();
    }

    @PostMapping
    public Banner createBanner(@RequestBody Banner banner){
        return bannerService.create(banner);
    }

    @PutMapping
    public Banner updateBanner(@RequestBody Banner banner){
        return bannerService.update(banner);
    }
}
