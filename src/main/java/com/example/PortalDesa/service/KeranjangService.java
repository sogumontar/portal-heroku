package com.example.PortalDesa.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Service
public interface KeranjangService {
    public List findAll();
    public List findAllBySkuCustomer(String skuCustomer);
    public List findAllByMerchant(String skuDesa);
    Integer check(String idProduk,String skuCustomer);
    Integer update(String id, Integer jumlah);
    void deleteById(String id);

}
