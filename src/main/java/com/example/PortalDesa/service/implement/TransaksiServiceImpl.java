package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.repository.KeranjangRepo;
import com.example.PortalDesa.repository.TransaksiProdukRepo;
import com.example.PortalDesa.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Service
public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    TransaksiProdukRepo transaksiProdukRepo;

    @Autowired
    KeranjangRepo keranjangRepo;

    @Override
    public void save(TransaksiProduk transaksiProduk, Integer status) {
        TransaksiProduk transaksiProduk1 = new TransaksiProduk(
                transaksiProduk.getSkuProduk(),
                transaksiProduk.getSkuCustomer(),
                transaksiProduk.getAlamat(),
                transaksiProduk.getHarga(),
                transaksiProduk.getMetode(),
                status
        );
        transaksiProdukRepo.save(transaksiProduk1);
    }

    @Override
    public void update(String idpesanan,String idCustomer, String base64) {
        Integer val = transaksiProdukRepo.counter(idCustomer);
        val++;
        File currentDirFile = new File("");
        String helper = currentDirFile.getAbsolutePath();
        String currentDir = helper+"/Picture/Resi";
        String pict =idCustomer+"-"+val.toString()+".png";
        String partSeparator = ",";
        String encodedImg ="";
        if (base64.contains(partSeparator)) {
            encodedImg = base64.split(partSeparator)[1];
        }
        File file =new File(currentDir+"/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] decoder = Base64.getDecoder().decode(encodedImg);
            fos.write(decoder);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        transaksiProdukRepo.update(idpesanan,pict);
    }

    @Override
    public void updateCart(String skuUser) {
        keranjangRepo.updateKeranjang(skuUser);
    }
}
