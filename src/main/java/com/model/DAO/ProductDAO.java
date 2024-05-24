package com.model.DAO;

import com.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDAO extends JpaRepository<Product, Integer> {

}
