package com.model.service.impl;

import com.model.DAO.DimensionDAO;
import com.model.entities.Dimension;
import com.model.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DimensionServiceImpl implements DimensionService {
    @Autowired
    DimensionDAO dao;

    @Override
    public List<Dimension> findAll() {
        return dao.findAll();
    }

    @Override
    public Dimension create(Dimension dimension) {
        return dao.save(dimension);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
