package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.TransaksiControllerRoute;
import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.repository.TransaksiProdukRepo;
import com.example.PortalDesa.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Controller
@RequestMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI)
public class TransaksiController {

    @Autowired
    TransaksiService transaksiService;

    @Autowired
    TransaksiProdukRepo transaksiProdukRepo;
    @PutMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_BAYAR_RESI)
    public ResponseEntity<?> update(@PathVariable  String idPesanan, @RequestBody TransaksiProduk transaksiProduk){
        System.out.println(idPesanan +"    "+transaksiProduk.getSkuCustomer()+"     "+transaksiProduk.getResi());
        transaksiService.update(idPesanan,transaksiProduk.getSkuCustomer(),transaksiProduk.getResi());
        return ResponseEntity.ok("");
    }

    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD)
    public ResponseEntity<?> add( @RequestBody TransaksiProduk transaksiProduk){
        System.out.println(transaksiProduk);
        transaksiService.save(transaksiProduk,2);
        return ResponseEntity.ok("Transaction Success");
    }
    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD_CART)
    public ResponseEntity<?> addToCart( @RequestBody TransaksiProduk transaksiProduk){
        transaksiService.save(transaksiProduk,1);
        return ResponseEntity.ok("Add To Cart Success");
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_CART_BY_SKU)
    public ResponseEntity<?> findAllCart(@PathVariable  String sku){
        return ResponseEntity.ok(transaksiProdukRepo.findAllCartBySku(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_MASIH_PESAN_BY_SKU)
    public ResponseEntity<?> findAllPesanan(@PathVariable  String sku){
        return ResponseEntity.ok(transaksiProdukRepo.findAllPesananBySku(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_SUDAH_BAYAR_BY_SKU)
    public ResponseEntity<?> findAllPesananSelesai(@PathVariable  String sku){
        return ResponseEntity.ok(transaksiProdukRepo.findAllPesananSelesaBySku(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN)
    public ResponseEntity<?> findAllPesanan(){
        return ResponseEntity.ok(transaksiProdukRepo.findAllByStatus(2));
    }
}
