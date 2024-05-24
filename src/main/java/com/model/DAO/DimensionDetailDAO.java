package com.model.DAO;

import com.model.entities.DimensionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DimensionDetailDAO extends JpaRepository<DimensionDetail, Integer> {
    @Query("SELECT d FROM DimensionDetail d WHERE d.product.id=?1")
    List<DimensionDetail> findDimensionDetailByProductId(Integer id);

    @Query("SELECT MIN(d.price) FROM DimensionDetail d WHERE d.product.id=?1")
    public Double findByProductMINId(Integer id);
    @Query("SELECT MAX(d.price) FROM DimensionDetail d WHERE d.product.id=?1")
    public Double findByProductMAXId(Integer id);
}
