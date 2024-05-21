package com.model.DAO;

import com.model.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Integer> {
}
