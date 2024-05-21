package com.model.service;

import com.model.entities.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductCategoryService {
    public List<ProductCategory> findAll() ;

    public ProductCategory findById(Integer id) ;

    public ProductCategory create(ProductCategory productCategory) ;

    public ProductCategory update(ProductCategory productCategory) ;

    public void delete(Integer id) ;
}
