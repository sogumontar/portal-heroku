package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Repository
public interface ArtikelRepo extends JpaRepository<Artikel, String> {

    List findAllByJenis(String jenis);

    @Query("SELECT k ,p from Artikel k JOIN Desa p  ON k.skuAdmin LIKE p.skuAdmin ")
    List findAllForWeb();

    @Query("SELECT k ,p from Artikel k JOIN Desa p  ON k.skuAdmin LIKE p.skuAdmin WHERE k.jenis LIKE?1  AND k.skuAdmin LIKE?2")
    List findAllByJenis(String jenis, String sku);

    @Query("SELECT k ,p from Artikel k JOIN Desa p  ON k.skuAdmin LIKE p.skuAdmin  WHERE k.skuAdmin LIKE?1")
    List findAllBySkuAdminForWeb(String skuAdmin);

    @Query("SELECT k ,p from Artikel k JOIN Desa p  ON k.skuAdmin LIKE p.skuAdmin  WHERE k.id LIKE?1")
    Artikel findFirstByIdForWeb(String id);

    List findAllBySkuAdmin(String skuAdmin);

    List findAllBySkuAdminAndJenis(String skuAdmin, String jenis);

    Artikel findFirstById(String id);

    void deleteById(String id);

    @Transactional
    @Modifying
    @Query("UPDATE Artikel p  SET p.isi=?2, p.judul=?3, p.penulis=?4, p.sumber=?5 WHERE p.id LIKE ?1")
    void updateArtikel(String id, String isi, String judul, String penulis, String sumber);

}
