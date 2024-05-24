package com.model.service.impl;

import com.model.DAO.BannerDAO;
import com.model.entities.Banner;
import com.model.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceIml implements BannerService {
    @Autowired
    BannerDAO banner;

    @Override
    public List<Banner> findAll() {
        // Logic để tìm tất cả các Banner
        return banner.findAll();
    }

    @Override
    public Banner findById(Integer id) {
        // Logic để tìm Banner theo id
        return null;
    }

    @Override
    public Banner create(Banner banner) {
        // Logic để tạo mới Banner
        return null;
    }

    @Override
    public Banner update(Banner banner) {
        // Logic để cập nhật Banner
        return null;
    }

    @Override
    public void delete(Integer id) {
        // Logic để xóa Banner
    }
}
