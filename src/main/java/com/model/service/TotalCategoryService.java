package com.model.service;
import com.model.entities.TotalCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TotalCategoryService {
    public List<TotalCategory> findAll() ;

    public TotalCategory create(TotalCategory totalCategory) ;

    public void delete(Integer id) ;
}
