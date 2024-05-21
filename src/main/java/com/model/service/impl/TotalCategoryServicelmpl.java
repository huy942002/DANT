package com.model.service.impl;

import com.model.DAO.TotalCategoryDAO;
import com.model.entities.TotalCategory;
import com.model.service.TotalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalCategoryServicelmpl implements TotalCategoryService {
    @Autowired
    TotalCategoryDAO totalCategoryDAO;

    @Override
    public List<TotalCategory> findAll() {
        return totalCategoryDAO.findAll();
    }

    @Override
    public TotalCategory create(TotalCategory totalCategory) {
        return totalCategoryDAO.save(totalCategory);
    }

    @Override
    public void delete(Integer id) {
        totalCategoryDAO.deleteById(id);
    }
}
