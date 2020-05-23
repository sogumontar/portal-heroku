package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.model.constant.PathImageDb;
import com.example.PortalDesa.model.sequence.SequenceProduk;
import com.example.PortalDesa.payload.request.ProdukDesaRequest;
import com.example.PortalDesa.repository.ProdukDesaRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.ProdukDesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.Base64;
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
            Integer fix =val+1;
            String finalSequence = "000".concat(String.valueOf(fix));
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
        Integer val = produkDesaRepo.counter(request.getSkuDesa());
        System.out.println(val);
        Integer fix= val+1;
        String pict = request.getSkuDesa()+"-"+fix.toString()+".png";
        ProdukDesa produkDesa = new ProdukDesa(
                skuGenerator(request.getNama(), request.getSkuDesa()),
                request.getNama(),
                request.getHarga(),
                PathImageDb.PATH_FOR_IMAGE_PRODUK_DESA+pict,
                request.getDeskripsi(),
                request.getSkuDesa(),
                1
        );
        produkDesaRepo.save(produkDesa);
    }

    @Override
    public List findAllBySkuDesa(String sku) {
        return produkDesaRepo.findAllBySkuAdmin(sku);
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
        produkDesaRepo.updateBySku(
                sku,
                request.getNama(),
                request.getHarga(),
                request.getDeskripsi()
        );
    }

//    @Override
//    @Transactional
//    public void updateProdukWithGambar(String sku, ProdukDesaRequest request) {
//        produkDesaRepo.updateBySkuWithGambar(
//                sku,
//                request.getNama(),
//                request.getHarga(),
//                request.getDeskripsi(),
//                PathImageDb.PATH_FOR_IMAGE_PRODUK_DESA+request.getGambar()
//        );
//    }

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

    @Override
    public void addGambarDesa(String base64, String sku) {
        Integer val = produkDesaRepo.counter(sku);
        System.out.println(val);
        Integer fix= val+1;
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/ProdukDesa/";
        String pict =sku+"-"+fix.toString()+".png";
        String partSeparator = ",";
        String encodedImg ="";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file =new File(currentDir+"/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
//            byte[] decoder = Base64.getDecoder().decode(encodedImg);
            byte[] dataBytes =  Base64.getMimeDecoder().decode(encodedImg);
            fos.write(dataBytes);
            System.out.println("Image file saved " + base64);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateGambarDesa(String base64, String sku) {
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/ProdukDesa/";
        String pict =sku;
        String partSeparator = ",";
        String encodedImg ="";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file =new File(currentDir+"/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
//            byte[] decoder = Base64.getDecoder().decode(encodedImg);
            byte[] dataBytes =  Base64.getMimeDecoder().decode(encodedImg);
            fos.write(dataBytes);
            System.out.println("Image file saved " + base64);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
