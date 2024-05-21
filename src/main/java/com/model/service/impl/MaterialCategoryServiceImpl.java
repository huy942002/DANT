package com.model.service.impl;

import com.model.DAO.MaterialCategoryDAO;
import com.model.entities.MaterialCategory;
import com.model.service.MaterialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialCategoryServiceImpl implements MaterialCategoryService {
    @Autowired
    MaterialCategoryDAO dao;

    @Override
    public List<MaterialCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public MaterialCategory create(MaterialCategory materialCategory) {
        return dao.save(materialCategory);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
