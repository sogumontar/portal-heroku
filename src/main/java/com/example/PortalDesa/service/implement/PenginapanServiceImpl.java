package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Penginapan;
import com.example.PortalDesa.model.sequence.SequenceProduk;
import com.example.PortalDesa.payload.request.PenginapanRequest;
import com.example.PortalDesa.repository.PenginapanRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.PenginapanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@Service
public class PenginapanServiceImpl implements PenginapanService {
    @Autowired
    PenginapanRepo penginapanRepo;
    @Autowired
    SequenceProdukRepo sequenceProdukRepo;

    @Override
    public void activate(String sku) {
        penginapanRepo.activatePenginapan(sku);
    }

    @Override
    public List findAll() {
        return penginapanRepo.findAll();
    }

    @Override
    public void save(PenginapanRequest request) {
        Penginapan penginapan = new Penginapan(
                skuGenereator(request.getDesa(), request.getNama()),
                request.getNama(),
                request.getHarga(),
                request.getDeskripsi(),
                request.getJumlahKamar(),
                request.getLokasi(),
                request.getGambar(),
                request.getDesa(),
                request.getKecamatan(),
                1
        );
        penginapanRepo.save(penginapan);
    }

    @Override
    public String skuGenereator(String desa, String namaPenginapan) {
        String key = substr(namaPenginapan) + "-" + substr(desa);
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
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public Penginapan findBySku(String sku) {
        return penginapanRepo.findFirstBySku(sku);
    }

    @Override
    public void update(String sku, PenginapanRequest request) {
        penginapanRepo.updateBySku(sku, request.getNama(), request.getHarga(), request.getDeskripsi(), request.getJumlahKamar(), request.getLokasi(), request.getDesa(), request.getKecamatan());
    }

    @Override
    public void updateWithGambar(String sku, PenginapanRequest request) {
        penginapanRepo.updateWithGambar(sku, request.getNama(), request.getHarga(), request.getDeskripsi(), request.getJumlahKamar(), request.getLokasi(), request.getGambar(), request.getDesa(), request.getKecamatan());
    }

    @Override
    public void deleteBySku(String sku) {
        penginapanRepo.deleteBySku(sku);
    }

    @Override
    public void suspendBySku(String sku) {
        penginapanRepo.suspendBySku(sku);
    }
}
