package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.repository.KeranjangRepo;
import com.example.PortalDesa.service.KeranjangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Service
public class KeranjangServiceImpl implements KeranjangService {

    @Autowired
    KeranjangRepo keranjangRepo;

    @Override
    public List findAll() {
        return keranjangRepo.findAll();
    }

    @Override
    public List findAllBySkuCustomer(String skuCustomer) {
        return keranjangRepo.findAllBySkuCustomer(skuCustomer);
    }

    @Override
    public List findAllByMerchant(String skuDesa) {
        return keranjangRepo.findAllByMerchant(skuDesa);
    }

    @Override
    public Integer check(String idProduk, String skuCustomer) {
        return keranjangRepo.check(idProduk,skuCustomer);
    }


    @Override
    public Integer update(String id, Integer jumlah) {
        return keranjangRepo.update(id,jumlah);
    }

    @Override
    public void deleteById(String id) {
        keranjangRepo.deleteById(id);
    }
}
