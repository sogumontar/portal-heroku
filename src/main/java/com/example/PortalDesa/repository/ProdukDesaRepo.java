package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Desa;
import com.example.PortalDesa.model.ProdukDesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Repository
public interface ProdukDesaRepo extends JpaRepository<ProdukDesa, String> {

    @Query("SELECT p FROM ProdukDesa p WHERE p.status =1 ")
    public List<ProdukDesa> findAll();

    public ProdukDesa findFirstBySku(String sku);

    @Query("SELECT p FROM ProdukDesa p WHERE p.status =1 AND p.skuDesa LIKE ?1 ")
    List findAllBySkuAdmin(String skuAdmin);

    @Modifying
    @Transactional
    @Query("UPDATE ProdukDesa p  SET p.nama=?2, p.harga=?3, p.deskripsi=?4 WHERE p.sku LIKE ?1")
    public void updateBySku(String sku, String nama, Integer harga, String deskripsi );

    @Modifying
    @Transactional
    @Query("UPDATE ProdukDesa p  SET p.nama=?2, p.harga=?3, p.deskripsi=?4, p.gambar=?5 WHERE p.sku LIKE ?1")
    public void updateBySkuWithGambar(String sku, String nama, Integer harga, String deskripsi, String gambar);

    @Modifying
    @Transactional
    @Query("UPDATE ProdukDesa p  SET p.status=2 WHERE p.sku LIKE ?1")
    public void suspendProduk(String sku);

    @Modifying
    @Transactional
    @Query("UPDATE ProdukDesa p  SET p.status=3 WHERE p.sku LIKE ?1")
    public void deleteBySku(String sku);

    @Modifying
    @Transactional
    @Query("UPDATE ProdukDesa p  SET p.status=1 WHERE p.sku LIKE ?1")
    public void activate(String sku);

    public List<ProdukDesa> findAllByStatus(Integer status);

    @Query("SELECT COUNT(u.sku) FROM ProdukDesa u WHERE u.sku LIKE ?1 ")
    Integer counter (String skuDesa);

}
