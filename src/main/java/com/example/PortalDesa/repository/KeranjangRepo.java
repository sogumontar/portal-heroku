package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Keranjang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Repository
public interface KeranjangRepo extends JpaRepository<Keranjang,String> {
    @Query("SELECT k from Keranjang k where k.status=1")
    List findAll();

    @Query("SELECT k from Keranjang k where k.status=1 AND  k.idCustomer LIKE ?1")
    List findAllBySkuCustomer(String skuCustomer);

    @Query("SELECT k from Keranjang k where k.status=1 AND  k.skuDesa LIKE ?1")
    List findAllByMerchant(String skuDesa);

}
