package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.repository.KecamatanRepo;
import com.example.PortalDesa.service.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Service
public class KecamatanServiceImpl implements KecamatanService {

    @Autowired
    KecamatanRepo kecamatanRepo;

    @Override
    public List findAll() {
        return kecamatanRepo.findAll();
    }

    @Override
    public Kecamatan findFirstByNama(String name) {
        return kecamatanRepo.findFirstByNama(name);
    }


}
