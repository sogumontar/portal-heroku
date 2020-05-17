package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.TransaksiProduk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Repository
public interface TransaksiProdukRepo extends JpaRepository<TransaksiProduk,String> {
    @Query("SELECT p FROM TransaksiProduk p, ProdukDesa d WHERE AND p.status =1 AND p.skuCustomer LIKE ?1")
    public List findAllCartBySku(String sku);
    @Query("SELECT p FROM TransaksiProduk p, ProdukDesa d WHERE p.status =2 AND p.skuCustomer LIKE ?1")
    public List findAllPesananBySku(String sku);
    @Query("SELECT p   FROM TransaksiProduk p, ProdukDesa d WHERE p.status =3 AND p.skuCustomer LIKE ?1")
    public List findAllPesananSelesaBySku(String sku);

    public List findAllByStatus(Integer status);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiProduk p  SET p.resi=?2 , p.status=3 WHERE p.id LIKE ?1")
    public void update(String idPesanan, String gambar);

    @Query("SELECT COUNT(u.resi) FROM TransaksiProduk u WHERE u.skuCustomer LIKE ?1  AND u.status=2")
    Integer counter (String skuCustomer);
}
