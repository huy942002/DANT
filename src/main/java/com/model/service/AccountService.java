package com.model.service;

import com.model.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface AccountService {
    public List<Account> findAll() ;
    public Optional<Account> findById(String username) ;
    public List<Account> getAdministrators() ;
}
