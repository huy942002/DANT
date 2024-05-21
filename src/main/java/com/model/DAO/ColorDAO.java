package com.model.DAO;

import com.model.entities.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDAO extends JpaRepository<Color, Integer> {
}
