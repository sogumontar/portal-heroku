package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Artikel;
import com.example.PortalDesa.payload.request.ArtikelRequest;
import com.example.PortalDesa.repository.ArtikelRepo;
import com.example.PortalDesa.service.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Service
public class ArtikelServiceImpl implements ArtikelService {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    @Autowired
    ArtikelRepo artikelRepo;

    @Override
    public List findAllArtikelForWeb() {
        return artikelRepo.findAllForWeb();
    }

    @Override
    public List findAllArtikelBySkuForWeb(String sku) {
        return artikelRepo.findAllBySkuAdminForWeb(sku);
    }

    @Override
    public Artikel findDetailArtikelByIdForWeb(String Id) {
        return artikelRepo.findFirstByIdForWeb(Id);
    }

    @Override
    public List findAllArtikel() {
        return artikelRepo.findAll();
    }

    @Override
    public List findAllArtikelBySku(String sku) {
        return artikelRepo.findAllBySkuAdmin(sku);
    }

    @Override
    public Artikel findDetailArtikelById(String Id) {
        return artikelRepo.findFirstById(Id);
    }

    @Override
    public Artikel save(String sku, ArtikelRequest artikelRequest) {
        Artikel artikel= new Artikel(
                UUID.randomUUID().toString(),
                artikelRequest.getJudul(),
                dtf.format(now).toString(),
                artikelRequest.getJenis(),
                artikelRequest.getIsi(),
                artikelRequest.getSumber(),
                artikelRequest.getPenulis(),
                sku,
                1
        );
        return artikelRepo.save(artikel);
    }

    @Override
    public String update(String id, ArtikelRequest artikelRequest) {
        artikelRepo.updateArtikel(id,artikelRequest.getIsi(),artikelRequest.getJudul(),artikelRequest.getPenulis(),artikelRequest.getSumber());
        return "Update Sukses";
    }

    @Override
    public Boolean delete(String id) {
        artikelRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
