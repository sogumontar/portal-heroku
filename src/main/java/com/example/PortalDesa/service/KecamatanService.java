package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Kecamatan;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
public interface KecamatanService {
    public List findAll();

    public Kecamatan findFirstByNama(String name);

}
