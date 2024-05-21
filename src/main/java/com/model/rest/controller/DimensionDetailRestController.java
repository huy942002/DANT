package com.model.rest.controller;

import com.model.DAO.DimensionDetailDAO;
import com.model.entities.DimensionDetail;
import com.model.service.DimensionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/dimensionDetail")
public class DimensionDetailRestController {
    @Autowired
    DimensionDetailService dimensionDetailService;
    @Autowired
    DimensionDetailDAO dao;

    @GetMapping
    public List<DimensionDetail> dimensionDetails(){
        return dimensionDetailService.findAll();
    }

    @GetMapping("{id}")
    public List<DimensionDetail> dimensionDetailList(@PathVariable("id") Integer id){
        return dao.findDimensionDetailByProductId(id);
    }

    @PostMapping
    public DimensionDetail dimensionDetail(@RequestBody DimensionDetail dimensionDetail){
        return dimensionDetailService.create(dimensionDetail);
    }

    @DeleteMapping("{id}")
    public void dimensionDetail_dele(@PathVariable("id") Integer id){
        dimensionDetailService.delete(id);
    }
}
