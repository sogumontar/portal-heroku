package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Artikel;
import com.example.PortalDesa.payload.request.ArtikelRequest;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface ArtikelService {
    //For Web
    List findAllArtikelForWeb();
    List findAllArtikelBySkuForWeb(String sku);
    Artikel findDetailArtikelByIdForWeb(String Id);


    List findAllArtikel();
    List findAllArtikelBySku(String sku);
    Artikel findDetailArtikelById(String Id);
    Artikel save(String sku, ArtikelRequest artikelRequest);
    String update(String id, ArtikelRequest artikelRequest);
    Boolean delete(String id);
}
