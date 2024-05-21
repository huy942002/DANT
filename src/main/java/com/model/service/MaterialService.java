package com.model.service;


import com.model.entities.Material;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MaterialService {
    public List<Material> findAll() ;

    public Material create(Material material) ;

    public void delete(Integer id) ;
}
