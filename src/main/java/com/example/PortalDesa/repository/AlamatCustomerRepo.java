package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Repository
public interface AlamatCustomerRepo extends JpaRepository<CustomerAddress,String> {
    public CustomerAddress findFirstBySku(String sku);
    @Modifying
    @Transactional
    @Query("UPDATE CustomerAddress p  SET p.alamat=?1 WHERE p.sku LIKE ?2")
    public void update(String alamat , String sku);

}
