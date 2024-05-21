package com.model.service;


import com.model.entities.Authority;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorityService {
    public List<Authority> findAll() ;

    public Authority create(Authority auth) ;

    public void delete(Integer id) ;

    public List<Authority> findAuthoritiesOfAdministrators() ;
}
