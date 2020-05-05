package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Desa;
import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.model.defaults.KecamatanDefaults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/04/2020.
 */
@Repository
public interface DesaRepo extends JpaRepository<Desa,String> {
    @Query("SELECT p FROM Desa p WHERE p.status =1 ORDER BY p.kecamatan")
    public List findAll();
    public Desa findFirstByNama(String nama);
    public List findAllByKecamatan(Kecamatan kecamatan);
    public List findAllByKecamatan(KecamatanDefaults kecamatan);
    public Desa findFirstBySkuAdmin(String sku);
    @Transactional
    @Modifying
    @Query("UPDATE Desa d  SET d.nama=?2, d.namaKepalaDesa=?3, d.kecamatan=?4, d.jumlahPenduduk=?5, d.gambar=?6  WHERE d.skuAdmin LIKE ?1")
    void updateBySku(String sku, String nama, String  namaKepalaDesa, KecamatanDefaults kecamatan, Integer jumlahPenduduk, String gambar);

}
