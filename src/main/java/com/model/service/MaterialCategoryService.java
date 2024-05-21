package com.model.service;

import com.model.entities.MaterialCategory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MaterialCategoryService {
    public List<MaterialCategory> findAll() ;

    public MaterialCategory create(MaterialCategory materialCategory) ;

    public void delete(Integer id) ;
}
