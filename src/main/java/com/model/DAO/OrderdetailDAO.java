package com.model.DAO;

import com.model.entities.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderdetailDAO extends JpaRepository<Orderdetail, Integer> {
    @Query("SELECT o FROM Orderdetail o WHERE o.order =:order")
    List<Orderdetail> findByorderId(@Param("order") int order);
}
