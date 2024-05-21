package com.model.service.impl;

import com.model.DAO.RoleDAO;
import com.model.entities.Role;
import com.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO dao;

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }

    @Override
    public Role create(Role role) {
        return dao.save(role);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
