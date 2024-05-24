package com.model.controller;

import com.model.DAO.DimensionDetailDAO;
import com.model.DTO.ProductPriceDTO;
import com.model.entities.Product;
import com.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    DimensionDetailDAO dao;

    @GetMapping("/products/all")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductPriceDTO> getListPriceProduct(@PathVariable("id") Integer id){
        ProductPriceDTO productPriceDTO = new ProductPriceDTO();
        productPriceDTO.setProduct(productService.findById(id));
        productPriceDTO.setPriceMin(dao.findByProductMINId(id));
        productPriceDTO.setPriceMax(dao.findByProductMAXId(id));
        return new ResponseEntity<>(productPriceDTO,HttpStatus.OK);
    }
}
