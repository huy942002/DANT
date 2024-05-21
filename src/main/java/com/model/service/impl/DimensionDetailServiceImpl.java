package com.model.service.impl;

import com.model.DAO.DimensionDetailDAO;
import com.model.entities.DimensionDetail;
import com.model.service.DimensionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DimensionDetailServiceImpl implements DimensionDetailService {
    @Autowired
    DimensionDetailDAO dao;

    @Override
    public List<DimensionDetail> findAll() {
        return dao.findAll();
    }

    @Override
    public DimensionDetail create(DimensionDetail dimensionDetail) {
        return dao.save(dimensionDetail);
    }

//    @Override
//    public List<DimensionDetail> findByProductId(Integer id) {
//        return dao.findByProductId(id);
//    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
