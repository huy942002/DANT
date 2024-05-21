package com.model.service;

import com.model.entities.DimensionDetail;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DimensionDetailService {
    public List<DimensionDetail> findAll() ;

    public DimensionDetail create(DimensionDetail dimensionDetail) ;

//    public List<DimensionDetail> findByProductId(Integer id);
    public void delete(Integer id) ;
}
