package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Penginapan;
import com.example.PortalDesa.payload.request.PenginapanRequest;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
public interface PenginapanService {
    void activate(String sku);

    List findAll();

    void save(PenginapanRequest request);

    String skuGenereator(String desa, String namaPenginapan);

    String substr(String str);

    Penginapan findBySku(String sku);

    void update(String sku, PenginapanRequest request);

    void updateWithGambar(String sku, PenginapanRequest request);

    void deleteBySku(String sku);

    void suspendBySku(String sku);
}
