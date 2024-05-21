package com.model.service;

import com.model.entities.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    public List<Order> findAll() ;

    public Order findById(Integer id) ;

    public List<Order> findByOrdersdt(String sdt) ;

    public Order create(Order order) ;

    public Order update(Order order) ;

    public void delete(Integer id) ;
}
