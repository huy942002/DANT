package com.model.DAO;

import com.model.entities.Account;
import com.model.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
    @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<Account> accounts);
}
