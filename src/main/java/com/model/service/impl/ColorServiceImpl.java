package com.model.service.impl;

import com.model.DAO.ColorDAO;
import com.model.entities.Color;
import com.model.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorDAO dao;

    @Override
    public List<Color> findAll() {
        return dao.findAll();
    }

    @Override
    public Color create(Color color) {
        return dao.save(color);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
