package com.model.DAO;

import com.model.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialDAO extends JpaRepository<Material, Integer> {
}
