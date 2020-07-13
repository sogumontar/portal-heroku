package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.payload.request.KecamatanRequest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
public interface KecamatanService {
    public List findAll();

    public List findAllWithDesa();

    public Kecamatan findFirstByNama(String name);

    public void addNewKecamatan(KecamatanRequest kecamatanRequest) throws IOException;

    public void deleteBySku(String sku);

}
