package com.model.service.impl;

import com.model.DAO.OrderDAO;
import com.model.entities.Order;
import com.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO dao;

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Order> findByOrdersdt(String sdt) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return dao.save(order);
    }

    @Override
    public Order update(Order order) {
        return dao.save(order);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
