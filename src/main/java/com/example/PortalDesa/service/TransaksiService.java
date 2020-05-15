package com.example.PortalDesa.service;

import com.example.PortalDesa.model.TransaksiProduk;
import org.springframework.stereotype.Service;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Service
public interface TransaksiService {
    public void save(TransaksiProduk transaksiProduk,Integer status);
    public void update(String idPesanan,String idCustomer, String base64);
    public void updateCart(String idCart);
}
