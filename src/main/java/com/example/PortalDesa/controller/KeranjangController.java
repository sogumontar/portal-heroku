package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.KeranjangControllerRoute;
import com.example.PortalDesa.model.Keranjang;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.KeranjangRequestCheck;
import com.example.PortalDesa.repository.KeranjangRepo;
import com.example.PortalDesa.service.implement.KeranjangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Controller
@RequestMapping(KeranjangControllerRoute.ROUTE_KERANJANG)
public class KeranjangController {
    @Autowired
    KeranjangServiceImpl keranjangService;

    @Autowired
    KeranjangRepo keranjangRepo;

    //For Android
    @GetMapping(KeranjangControllerRoute.ROUTE_KERANJANG_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(keranjangService.findAll());
    }

    @GetMapping(KeranjangControllerRoute.ROUTE_KERANJANG_WITH_SKU_CUSTOMER)
    public ResponseEntity<?> findAllWithSkuCustomer(@PathVariable String sku) {
        return ResponseEntity.ok(keranjangService.findAllBySkuCustomer(sku));
    }

    @GetMapping(KeranjangControllerRoute.ROUTE_KERANJANG_WITH_SKU_MERCHANT)
    public ResponseEntity<?> findAllWithSkuMerchant(@PathVariable String sku) {
        return ResponseEntity.ok(keranjangService.findAllByMerchant(sku));
    }

    //For Web
    @GetMapping(KeranjangControllerRoute.ROUTE_WEB_KERANJANG_ALL)
    public ResponseEntity<?> findAllForWeb() {
        return ResponseEntity.ok(keranjangRepo.findAllForWeb());
    }

    @GetMapping(KeranjangControllerRoute.ROUTE_WEB_KERANJANG_WITH_SKU_CUSTOMER)
    public ResponseEntity<?> findAllWithSkuCustomerForWeb(@PathVariable String sku) {
        return ResponseEntity.ok(keranjangRepo.findAllBySkuCustomerForWeb(sku));
    }

    @GetMapping(KeranjangControllerRoute.ROUTE_WEB_KERANJANG_WITH_SKU_MERCHANT)
    public ResponseEntity<?> findAllWithSkuMerchantForWeb(@PathVariable String sku) {
        return ResponseEntity.ok(keranjangRepo.findAllByMerchantForWeb(sku));
    }

    @PostMapping(KeranjangControllerRoute.ROUTE_KERANJANG_SAVE)
    public ResponseEntity<?> save(@RequestBody Keranjang keranjang) {
        KeranjangRequestCheck keranjangRequestCheck= new KeranjangRequestCheck(
                keranjang.getId(),
                keranjang.getIdProduk(),
                keranjang.getIdCustomer(),
                keranjang.getJumlah()
        );
        Keranjang keranjang1 =keranjangRepo.findByIdProdukAndIdCustomerAndStatus(keranjang.getIdProduk(),keranjang.getIdCustomer(),1);
        if(keranjang1!=null){
            updateCart(keranjangRequestCheck, keranjang1.getJumlah()+keranjang.getJumlah());
        }else {
            Keranjang keranjang2 = new Keranjang(
                    keranjang.getIdCustomer(),
                    keranjang.getIdProduk(),
                    keranjang.getJumlah(),
                    keranjang.getSkuDesa(),
                    1,
                    keranjang.getHarga()
            );
            keranjangRepo.save(keranjang2);
        }
        return ResponseEntity.ok(new DefaultResponse("Success", 201));
    }

    public Boolean checks(KeranjangRequestCheck keranjangRequestCheck){
        Boolean val=keranjangRepo.existsByIdProdukAndIdCustomerAndStatus(keranjangRequestCheck.getIdProduk(), keranjangRequestCheck.getSkuCustomer(),1);
        return val;
    }

    public void updateCart(KeranjangRequestCheck keranjangRequestCheck, Integer jumlah){
        keranjangRepo.updateJumlahCart(keranjangRequestCheck.getIdProduk(), keranjangRequestCheck.getSkuCustomer(),jumlah);
    }

    @PostMapping(KeranjangControllerRoute.ROUTE_KERANJANG_CHECK)
    public ResponseEntity<?> check(@RequestBody KeranjangRequestCheck keranjangRequestCheck) {
//        Boolean val=keranjangRepo.existsByIdProdukAndIdCustomerAndStatus(keranjangRequestCheck.getIdProduk(), keranjangRequestCheck.getSkuCustomer(),1);
        Integer value=0;
        if(checks(keranjangRequestCheck)==Boolean.TRUE){
            value=1;
        }
        return ResponseEntity.ok(new DefaultResponse("sukses",value));
    }


    @PutMapping(KeranjangControllerRoute.ROUTE_KERANJANG_UPDATE)
    public ResponseEntity<?> update(@RequestBody KeranjangRequestCheck requestCheck) {
        keranjangRepo.update(requestCheck.getId(),requestCheck.getJumlah());
        return ResponseEntity.ok(new DefaultResponse("sukses",200));
    }

    @DeleteMapping(KeranjangControllerRoute.ROUTE_KERANJANG_DELETE)
    public ResponseEntity<?> delete(@PathVariable String id){
        keranjangRepo.deleteById(id);
        return ResponseEntity.ok(new DefaultResponse("delete success",200));
    }


}
