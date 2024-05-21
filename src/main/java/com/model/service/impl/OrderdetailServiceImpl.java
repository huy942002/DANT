package com.model.service.impl;

import com.model.DAO.OrderdetailDAO;
import com.model.entities.Orderdetail;
import com.model.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderdetailServiceImpl implements OrderdetailService {
    @Autowired
    OrderdetailDAO dao;
    @Override
    public List<Orderdetail> findAll() {
        return dao.findAll();
    }

    @Override
    public Orderdetail findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Orderdetail> findByorderId(int orderId) {
        return dao.findByorderId(orderId);
    }

    @Override
    public Orderdetail create(Orderdetail orderdetail) {
        return dao.save(orderdetail);
    }

    @Override
    public Orderdetail update(Orderdetail orderdetail) {
        return dao.save(orderdetail);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
