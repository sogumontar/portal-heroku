package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.ProdukDesaControllerRoute;
import com.example.PortalDesa.controller.route.TransaksiControllerRoute;
import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.repository.TransaksiProdukRepo;
import com.example.PortalDesa.service.TransaksiService;
import com.example.PortalDesa.service.implement.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @Autowired
    StorageServiceImpl storageService;

    @PutMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_BAYAR_RESI)
    public ResponseEntity<?> update(@PathVariable  String idPesanan, @RequestBody TransaksiProduk transaksiProduk){
        System.out.println(idPesanan +"    "+transaksiProduk.getSkuCustomer()+"     "+transaksiProduk.getResi());
        transaksiService.update(idPesanan,transaksiProduk.getSkuCustomer(),transaksiProduk.getResi());
        return ResponseEntity.ok(new DefaultResponse("update sukses",200));
    }

    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD)
    public ResponseEntity<?> add( @RequestBody TransaksiProduk transaksiProduk){
        System.out.println(transaksiProduk);
        transaksiService.save(transaksiProduk,2);
        transaksiService.updateCart(transaksiProduk.getSkuCustomer());
        return ResponseEntity.ok(new DefaultResponse("Transaction Success",200));
    }
    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD_CART)
    public ResponseEntity<?> addToCart( @RequestBody TransaksiProduk transaksiProduk){
        transaksiService.save(transaksiProduk,1);
        return ResponseEntity.ok(new DefaultResponse("Add To Cart Success",200));
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

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN_SUDAH_BAYAR)
    public ResponseEntity<?> findAllPesananSudahBayar(){
        return ResponseEntity.ok(transaksiProdukRepo.findAllByStatus(3));
    }

    @PutMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_CANCEL_PESANAN)
    public ResponseEntity<?> cancelPesanan(@PathVariable String sku){
        transaksiProdukRepo.cancel(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses",200));
    }

    @PutMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_BALIKIN_PESANAN)
    public ResponseEntity<?> kembalikanPesanan(@PathVariable String sku){
        transaksiProdukRepo.balikin(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses",200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_IMAGE_RESI)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("Resi",filePath), headers, HttpStatus.OK);
    }
}
