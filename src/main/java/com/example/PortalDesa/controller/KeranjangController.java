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

    @PostMapping(KeranjangControllerRoute.ROUTE_KERANJANG_SAVE)
    public ResponseEntity<?> save(@RequestBody Keranjang keranjang) {
        Keranjang keranjang1 = new Keranjang(
                keranjang.getIdCustomer(),
                keranjang.getIdProduk(),
                keranjang.getJumlah(),
                keranjang.getSkuDesa(),
                1
        );
        keranjangRepo.save(keranjang1);
        return ResponseEntity.ok(new DefaultResponse("Success", 201));
    }

    @PostMapping(KeranjangControllerRoute.ROUTE_KERANJANG_CHECK)
    public ResponseEntity<?> check(@RequestBody KeranjangRequestCheck keranjangRequestCheck) {
        Integer val=keranjangRepo.check(keranjangRequestCheck.getIdProduk(), keranjangRequestCheck.getSkuCustomer());
        return ResponseEntity.ok(new DefaultResponse("sukses",val));
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
