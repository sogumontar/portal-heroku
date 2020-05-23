package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Penginapan;
import com.example.PortalDesa.model.constant.PathImageDb;
import com.example.PortalDesa.model.sequence.SequenceProduk;
import com.example.PortalDesa.payload.request.PenginapanRequest;
import com.example.PortalDesa.repository.PenginapanRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.PenginapanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
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
    public List findAllBySku(String sku) {
        return penginapanRepo.findAllBySkuMerchant(sku);
    }

    @Override
    public void save(PenginapanRequest request) {
        Integer val = penginapanRepo.counter(request.getSkumerchant());
        System.out.println(val);
        Integer fix =val+1;
        String pict = request.getSkumerchant()+"-"+fix.toString()+".png";
        Penginapan penginapan = new Penginapan(
                skuGenereator(request.getDesa(), request.getNama()),
                request.getNama(),
                request.getHarga(),
                request.getDeskripsi(),
                request.getJumlahKamar(),
                request.getLokasi(),
                PathImageDb.PATH_FOR_IMAGE_PENGINAPAN+pict,
                request.getDesa(),
                request.getKecamatan(),
                request.getSkumerchant(),
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
    public String substr(String str) {
        return str.substring(0, 4).toUpperCase();
    }

    @Override
    public Penginapan findBySku(String sku) {
        return penginapanRepo.findFirstBySku(sku);
    }

    @Override
    public void update(String sku, PenginapanRequest request) {
        penginapanRepo.updateBySku(sku, request.getNama(), request.getHarga(), request.getDeskripsi(), request.getJumlahKamar(), request.getLokasi());
    }

    @Override
    public void updateWithGambar(String sku, PenginapanRequest request) {
        penginapanRepo.updateWithGambar(
                sku,
                request.getNama(),
                request.getHarga(),
                request.getDeskripsi(),
                request.getJumlahKamar(),
                request.getLokasi(),
                PathImageDb.PATH_FOR_IMAGE_PENGINAPAN + request.getGambar(),
                request.getDesa(),
                request.getKecamatan()
        );
    }

    @Override
    public void deleteBySku(String sku) {
        penginapanRepo.deleteBySku(sku);
    }

    @Override
    public void suspendBySku(String sku) {
        penginapanRepo.suspendBySku(sku);
    }

    @Override
    public void addGambarDesa(String base64, String sku) {
        Integer val = penginapanRepo.counter(sku);
        System.out.println(val);
        Integer fix =val+1;
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/Penginapan/";
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
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



    @Override
    public void updateGambarDesa(String base64, String nama) {
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/Penginapan/";
        String pict =nama;
        String partSeparator = ",";
        String encodedImg ="";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file =new File(currentDir+"/"+pict.substring(16));
        try(FileOutputStream fos = new FileOutputStream(file)){
//            byte[] decoder = Base64.getDecoder().decode(encodedImg);
            byte[] dataBytes =  Base64.getMimeDecoder().decode(encodedImg);
            fos.write(dataBytes);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public byte[] loadImage(String fileName) throws IOException {
        File file = new File( "images/Penginapan/" + fileName);
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);

            return bytes;
        } catch (IOException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }
}
