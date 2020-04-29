package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Kecamatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Repository
public interface KecamatanRepo extends JpaRepository<Kecamatan,String> {
    Kecamatan findFirstByNamaCamat(String namaCamat);
    Kecamatan findFirstByNama(String nama);
    Kecamatan findFirstBySku(String sku);
    Boolean existsByNama(String nama);
}
