package com.model.service.impl;

import com.model.DAO.ProductDAO;
import com.model.entities.Product;
import com.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Product> findByProductCategoryId(int productCategoryid) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return dao.save(product);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
