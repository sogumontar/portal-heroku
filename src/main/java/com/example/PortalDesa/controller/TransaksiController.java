package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.TransaksiControllerRoute;
import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.repository.TransaksiProdukRepo;
import com.example.PortalDesa.service.MailService;
import com.example.PortalDesa.service.TransaksiService;
import com.example.PortalDesa.service.UsersService;
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

    @Autowired
    MailService mailService;

    @Autowired
    UsersService usersService;

    @PutMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_BAYAR_RESI)
    public ResponseEntity<?> update(@PathVariable String idPesanan, @RequestBody TransaksiProduk transaksiProduk) {
        System.out.println(idPesanan + "    " + transaksiProduk.getSkuCustomer() + "     " + transaksiProduk.getResi());
        transaksiService.update(idPesanan, transaksiProduk.getSkuCustomer(), transaksiProduk.getResi());
        return ResponseEntity.ok(new DefaultResponse("update sukses", 200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND__BY_SKU)
    public ResponseEntity<?> findTransaksi(@PathVariable String sku){
        return ResponseEntity.ok().body(transaksiService.findById(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_TERIMA_PESANAN)
    public ResponseEntity<?> terimaPesanan(@PathVariable String idPesanan) {
        transaksiService.terimaPesanan(idPesanan);
        mailService.sendEmail(idPesanan,1);
        return ResponseEntity.ok(new DefaultResponse("terima pesanan sukses", 200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_TOLAK_PESANAN)
    public ResponseEntity<?> tolakPesanan(@PathVariable String idPesanan) {
        transaksiService.tolakPesanan(idPesanan);
        mailService.sendEmail(idPesanan,2);
        return ResponseEntity.ok(new DefaultResponse("tolak pesanan sukses", 200));
    }


    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD)
    public ResponseEntity<?> add(@RequestBody TransaksiProduk transaksiProduk) {
        System.out.println(transaksiProduk);
        transaksiService.save(transaksiProduk, 2);
        transaksiService.updateCart(transaksiProduk.getSkuCustomer());
        System.out.println(transaksiProduk.getSkuCustomer() + "        " +transaksiProduk.getId());
        Users users = usersService.findBySku(transaksiProduk.getSkuCustomer());
        System.out.println(transaksiProduk.getMetode()+ "    "+transaksiProduk.getAlamat()+ "    "+transaksiProduk.getHarga()+ "    "+users.getEmail());
        mailService.sendEmailPesanan(transaksiProduk.getMetode(),transaksiProduk.getAlamat(),transaksiProduk.getHarga(),users.getEmail());
        return ResponseEntity.ok(new DefaultResponse("Transaction Success", 200));
    }

    @PostMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_ADD_CART)
    public ResponseEntity<?> addToCart(@RequestBody TransaksiProduk transaksiProduk) {
        transaksiService.save(transaksiProduk, 1);
        return ResponseEntity.ok(new DefaultResponse("Add To Cart Success", 200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_CART_BY_SKU)
    public ResponseEntity<?> findAllCart(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiProdukRepo.findAllCartBySku(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_MASIH_PESAN_BY_SKU)
    public ResponseEntity<?> findAllPesanan(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiProdukRepo.findAllPesananBySku(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_SUDAH_BAYAR_BY_SKU)
    public ResponseEntity<?> findAllPesananSelesai(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiProdukRepo.findAllPesananSudahBayar(sku));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN)
    public ResponseEntity<?> findAllPesanan() {
        return ResponseEntity.ok(transaksiProdukRepo.findAllByStatus(2));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN_SUDAH_BAYAR)
    public ResponseEntity<?> findAllPesananSudahBayar() {
        return ResponseEntity.ok(transaksiProdukRepo.findAllPesananSudahBayarAdmin());
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_CANCEL_PESANAN)
    public ResponseEntity<?> cancelPesanan(@PathVariable String sku) {
        transaksiProdukRepo.cancel(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses", 200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_BALIKIN_PESANAN)
    public ResponseEntity<?> kembalikanPesanan(@PathVariable String sku) {
        transaksiProdukRepo.balikin(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses", 200));
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_IMAGE_RESI)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("Resi", filePath), headers, HttpStatus.OK);
    }

    @GetMapping(TransaksiControllerRoute.ROUTE_TRANSAKSI_KIRIM_EMAIL)
    public ResponseEntity<?> sendEmail(@PathVariable String idPesanan) {
        mailService.sendEmail(idPesanan,1);
        return ResponseEntity.ok("Success");
    }
}