package com.model.service;

import com.model.entities.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerService {
    
    public List<Banner> findAll() ;

    public Banner findById(Integer id) ;

    public Banner create(Banner banner);

    public Banner update(Banner banner) ;

    public void delete(Integer id) ;
}
