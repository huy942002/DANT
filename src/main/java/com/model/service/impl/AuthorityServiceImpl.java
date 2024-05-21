package com.model.service.impl;

import com.model.DAO.AccountDAO;
import com.model.DAO.AuthorityDAO;
import com.model.entities.Account;
import com.model.entities.Authority;
import com.model.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityDAO dao;

    @Autowired
    AccountDAO accountDAO;

    @Override
    public List<Authority> findAll() {
        return dao.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return dao.save(auth);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountDAO.getAdministrators();
        return dao.authoritiesOf(accounts);
    }
}
