package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.model.sequence.SequenceProduk;
import com.example.PortalDesa.payload.request.ProdukDesaRequest;
import com.example.PortalDesa.repository.ProdukDesaRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.ProdukDesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Service
public class ProdukDesaServiceImpl implements ProdukDesaService {

    @Autowired
    ProdukDesaRepo produkDesaRepo;

    @Autowired
    SequenceProdukRepo sequenceProdukRepo;

    @Override
    public String skuGenerator(String name, String desa) {
        String key = subStr(name) + "-" + subStr(desa);
        if (sequenceProdukRepo.existsByKey(key)) {
            SequenceProduk sequenceProduk = sequenceProdukRepo.findFirstByKey(key);
            Integer val = Integer.parseInt(sequenceProduk.getLast_seq());
            String finalSequence = "000".concat(String.valueOf(val + 1));
            sequenceProduk.setLast_seq(finalSequence);
            sequenceProdukRepo.save(sequenceProduk);
            return key + "-" + finalSequence;
        }
        SequenceProduk sequenceProduk = new SequenceProduk(key, "001");
        sequenceProdukRepo.save(sequenceProduk);
        return key + "-001";
    }

    @Override
    public String subStr(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public void save(ProdukDesaRequest request) {
        ProdukDesa produkDesa = new ProdukDesa(
                skuGenerator(request.getNama(), request.getDesa()),
                request.getNama(),
                request.getHarga(),
                request.getGambar(),
                request.getDeskripsi(),
                request.getDesa(),
                1
        );
        produkDesaRepo.save(produkDesa);
    }

    @Override
    public List<ProdukDesa> findAll() {
        return produkDesaRepo.findAll();
    }

    @Override
    public ProdukDesa findBySku(String sku) {
        return produkDesaRepo.findFirstBySku(sku);
    }

    @Override
    @Transactional
    public void updateProduk(String sku, ProdukDesaRequest request) {
        produkDesaRepo.updateBySku(sku, request.getNama(), request.getHarga(), request.getDeskripsi(), request.getDesa());
    }

    @Override
    @Transactional
    public void updateProdukWithGambar(String sku, ProdukDesaRequest request) {
        produkDesaRepo.updateBySkuWithGambar(sku, request.getNama(), request.getHarga(), request.getDeskripsi(), request.getDesa(), request.getGambar());
    }

    @Override
    @Transactional
    public void suspendProduk(String sku) {
        System.out.println(sku);
        produkDesaRepo.suspendProduk(sku);
    }

    @Override
    @Transactional
    public void deleteProduk(String sku) {
        produkDesaRepo.deleteBySku(sku);
    }

    @Override
    @Transactional
    public void activate(String sku) {
        produkDesaRepo.activate(sku);
    }

    @Override
    public List<ProdukDesa> findAllSuspend() {
        return produkDesaRepo.findAllByStatus(2);
    }
}
