package com.model.service;

import com.model.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    public List<Role> findAll() ;

    public Role create(Role role) ;

    public void delete(Integer id) ;
}
