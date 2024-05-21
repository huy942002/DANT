package com.model.service.impl;

import com.model.DAO.MaterialDAO;
import com.model.entities.Material;
import com.model.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialDAO dao;
    @Override
    public List<Material> findAll() {
        return dao.findAll();
    }

    @Override
    public Material create(Material material) {
        return dao.save(material);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
