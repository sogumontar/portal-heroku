package com.example.PortalDesa.service;

import com.example.PortalDesa.model.TransaksiPenginapan;
import org.springframework.stereotype.Service;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@Service
public interface TransaksiPenginapanService {
    public void save(TransaksiPenginapan transaksiPenginapan, Integer status);
    public void update(String idPesanan,String idCustomer, String base64);
    public void terimaPesanan(String idPesanan);
    public void tolakPesanan(String idPesanan);
    public TransaksiPenginapan findById(String idPesanan);
}
