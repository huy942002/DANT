package com.model.service;


import com.model.entities.Color;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ColorService {
    public List<Color> findAll() ;

    public Color create(Color color) ;

    public void delete(Integer id) ;
}
