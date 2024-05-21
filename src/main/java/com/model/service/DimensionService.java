package com.model.service;

import com.model.entities.Dimension;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DimensionService {
    public List<Dimension> findAll() ;

    public Dimension create(Dimension dimension) ;

    public void delete(Integer id) ;
}
