package com.model.service;

import com.model.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    public List<Product> findAll() ;

    public Product findById(Integer id) ;

    public List<Product> findByProductCategoryId(int productCategoryid) ;

    public Product create(Product product) ;

    public Product update(Product product) ;

    public void delete(Integer id) ;
}
