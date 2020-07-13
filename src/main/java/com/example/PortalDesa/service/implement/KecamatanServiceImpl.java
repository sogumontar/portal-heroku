package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.payload.request.KecamatanRequest;
import com.example.PortalDesa.repository.KecamatanRepo;
import com.example.PortalDesa.service.KecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Service
public class KecamatanServiceImpl implements KecamatanService {

    @Autowired
    KecamatanRepo kecamatanRepo;

    @Override
    public List findAll() {
        return kecamatanRepo.findAll();
    }

    @Override
    public List findAllWithDesa() {
        return kecamatanRepo.findAllWithDesa();
    }

    @Override
    public Kecamatan findFirstByNama(String name) {
        return kecamatanRepo.findFirstByNama(name);
    }

    @Override
    public void addNewKecamatan(KecamatanRequest kecamatanRequest) throws IOException {
        String rand = UUID.randomUUID().toString();
        Kecamatan kecamatan = new Kecamatan(
                rand,
                "foto.png",
                rand + ".png",
                kecamatanRequest.getNama(),
                kecamatanRequest.getNama()
        );
        System.out.println(kecamatanRequest.getGambarKecamatan());
        addImage(kecamatanRequest.getGambarKecamatan(), rand);
        kecamatanRepo.save(kecamatan);
    }

    @Override
    public void deleteBySku(String sku) {
        kecamatanRepo.deleteBySku(sku);
    }

    public void addImage(String base64, String skuDesa) throws IOException {
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/Kecamatan";
        String pict =skuDesa+".png";
        String partSeparator = ",";
        String encodedImg ="";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file =new File(currentDir+"/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] dataBytes =  Base64.getMimeDecoder().decode(encodedImg);
            fos.write(dataBytes);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


}
