package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.TransaksiPenginapan;
import com.example.PortalDesa.model.constant.PathImageDb;
import com.example.PortalDesa.repository.TransaksiPenginapanRepo;
import com.example.PortalDesa.service.TransaksiPenginapanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@Service
public class TransaksiPenginapanServiceImpl implements TransaksiPenginapanService {

    @Autowired
    TransaksiPenginapanRepo transaksiPenginapanRepo;

    @Override
    public void save(TransaksiPenginapan transaksiPenginapan, Integer status) {
        TransaksiPenginapan transaksiPenginapan1 = new TransaksiPenginapan(
                UUID.randomUUID().toString(),
                transaksiPenginapan.getSkuProduk(),
                transaksiPenginapan.getSkuCustomer(),
                transaksiPenginapan.getHarga(),
                transaksiPenginapan.getMetode(),
                transaksiPenginapan.getLamaMenginap(),
                transaksiPenginapan.getCheckin(),
                PathImageDb.PATH_FOR_IMAGE_TRANSAKSI+"Default.jpg",
                status,
                ""
        );
        transaksiPenginapanRepo.save(transaksiPenginapan1);
    }

    @Override
    public void update(String idPesanan, String idCustomer, String base64) {
        Integer val = transaksiPenginapanRepo.counter(idCustomer);
        val++;
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/src/main/resources/static/images/Resi/";
        String pict =idCustomer+"-"+"penginapan-"+val.toString()+".png";
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
        transaksiPenginapanRepo.update(idPesanan,pict);
    }


    @Override
    public void terimaPesanan(String idPesanan) {
        transaksiPenginapanRepo.actionPesanan(idPesanan,3);
    }

    @Override
    public void tolakPesanan(String idPesanan) {
        transaksiPenginapanRepo.actionPesanan(idPesanan,0);
    }

    @Override
    public TransaksiPenginapan findById(String idPesanan) {
        return transaksiPenginapanRepo.findFirstById(idPesanan);
    }
}
