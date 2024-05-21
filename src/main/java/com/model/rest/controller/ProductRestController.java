package com.model.rest.controller;

import com.model.DTO.ProductDTO;
import com.model.entities.ColorDetail;
import com.model.entities.DimensionDetail;
import com.model.entities.Product;
import com.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @Autowired
    ColorDetailService colorService;

    @Autowired
    DimensionDetailService dimensionService;

    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody ProductDTO productDTO){
        productService.create(productDTO.getProduct());
        List<Product> productList = productService.findAll();
        for (ColorDetail colorDetail : productDTO.getColorDetailList()) {
            ColorDetail c = new ColorDetail();
            c.setColor(colorDetail.getColor());
            c.setProduct(productList.get(productList.size()-1));
            colorService.create(c);
        }
        for (DimensionDetail dimensionDetail : productDTO.getDimensionDetailList()) {
            DimensionDetail d = new DimensionDetail();
            d.setDimension(dimensionDetail.getDimension());
            d.setProduct(productList.get(productList.size()-1));
            d.setPrice(dimensionDetail.getPrice());
            dimensionService.create(d);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> UpdateProduct(@RequestBody ProductDTO productDTO){
        productService.update(productDTO.getProduct());
        System.out.println(productDTO.getProduct().getId());
        List<Product> productList = productService.findAll();
        for (ColorDetail colorDetail : productDTO.getColorDetailList()) {
            ColorDetail c = new ColorDetail();
            c.setId(colorDetail.getId());
            c.setColor(colorDetail.getColor());
            c.setProduct(productDTO.getProduct());
            colorService.create(c);
        }
        for (DimensionDetail dimensionDetail : productDTO.getDimensionDetailList()) {
            DimensionDetail d = new DimensionDetail();
            d.setId(dimensionDetail.getId());
            d.setDimension(dimensionDetail.getDimension());
            d.setProduct(productDTO.getProduct());
            d.setPrice(dimensionDetail.getPrice());
            dimensionService.create(d);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
