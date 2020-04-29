package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Penginapan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@Repository
public interface PenginapanRepo extends JpaRepository<Penginapan, String> {
    @Query("SELECT p  FROM Penginapan p WHERE p.status=1")
    List findAll();
    Penginapan findFirstBySku(String sku);

    @Transactional
    @Modifying
    @Query("UPDATE Penginapan p  SET p.nama=?2, p.harga=?3, p.deskripsi=?4, p.jumlahKamar=?5, p.lokasi=?6, p.desa=?7, p.kecamatan=?8  WHERE p.sku LIKE ?1")
    void updateBySku(String sku, String nama, Integer harga, String deskripsi, Integer jumlahKamar, String lokasi, String desa, String kecamatan);

    @Transactional
    @Modifying
    @Query("UPDATE Penginapan p  SET p.nama=?2, p.harga=?3, p.deskripsi=?4, p.jumlahKamar=?5, p.lokasi=?6, p.gambar=?7, p.desa=?8, p.kecamatan=?9  WHERE p.sku LIKE ?1")
    void updateWithGambar(String sku, String nama, Integer harga, String deskripsi, Integer jumlahKamar, String lokasi, String gambar, String desa, String kecamatan);

    @Transactional
    @Modifying
    @Query("UPDATE Penginapan p  SET p.status=3 WHERE p.sku LIKE ?1")
    void deleteBySku(String sku);

    @Transactional
    @Modifying
    @Query("UPDATE Penginapan p  SET p.status=2 WHERE p.sku LIKE ?1")
    void suspendBySku(String sku);

    @Transactional
    @Modifying
    @Query("UPDATE Penginapan p  SET p.status=1 WHERE p.sku LIKE ?1")
    void activatePenginapan(String sku);
}
