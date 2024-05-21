package com.model.DAO;

import com.model.entities.MaterialCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialCategoryDAO extends JpaRepository<MaterialCategory, Integer> {
}
