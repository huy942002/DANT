package com.model.DAO;

import com.model.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("SELECT ar.account  FROM Authority ar WHERE role NOT IN ('DIRE')")
    List<Account> getAdministrators();
}
