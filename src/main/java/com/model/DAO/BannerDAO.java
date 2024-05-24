package com.model.DAO;

import com.model.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerDAO extends JpaRepository<Banner, Integer> {
}