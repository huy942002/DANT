package com.model.service.impl;


import com.model.DAO.AccountDAO;
import com.model.entities.Account;

import com.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO dao;

    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Account> findById(String username) {

        return dao.findById(username);
    }


    public List<Account> getAdministrators() {
        return dao.getAdministrators();
    }
}
