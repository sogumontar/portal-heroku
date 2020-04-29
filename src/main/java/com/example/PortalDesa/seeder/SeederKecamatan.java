package com.example.PortalDesa.seeder;

import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.model.defaults.KecamatanDefaults;
import com.example.PortalDesa.repository.KecamatanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/04/2020.
 */
@Component
public class SeederKecamatan {
    @Autowired
    KecamatanRepo kecamatanRepo;

    public void checkIfExist(KecamatanDefaults kecamatanDefaults) {
        if (!kecamatanRepo.existsByNama(kecamatanDefaults.toString())) {
            Kecamatan kecamatan = new Kecamatan();
            kecamatan.setSku(UUID.randomUUID().toString());
            kecamatan.setNama(kecamatanDefaults.toString());
            kecamatan.setFotoCamat("profile.png");
            kecamatan.setGambarKecamatan(kecamatanDefaults.toString()+".png");
            kecamatan.setNamaCamat("Camat " + kecamatanDefaults.toString());
            kecamatanRepo.save(kecamatan);
        }
    }

    @EventListener
    public void seeder(ContextRefreshedEvent contextRefreshedEvent) {
        int length = KecamatanDefaults.values().length;
        List list = Arrays.asList(KecamatanDefaults.values());
        for (int i = 0; i < length; i++) {
            checkIfExist((KecamatanDefaults) list.get(i));
        }
    }
}
