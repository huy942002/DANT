package com.model.DAO;

import com.model.entities.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimensionDAO extends JpaRepository<Dimension, Integer> {
}
