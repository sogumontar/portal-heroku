package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Kecamatan;
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
public interface KecamatanRepo extends JpaRepository<Kecamatan, String> {
    @Query("SELECT U , D FROM Kecamatan U , Desa D WHERE D.kec LIKE U.nama")
    List findAllWithDesa();

    Kecamatan findFirstByNamaCamat(String namaCamat);

    Kecamatan findFirstByNama(String nama);

    Kecamatan findFirstBySku(String sku);

    Boolean existsByNama(String nama);

    @Transactional
    @Modifying
    void deleteBySku(String sku);
}
