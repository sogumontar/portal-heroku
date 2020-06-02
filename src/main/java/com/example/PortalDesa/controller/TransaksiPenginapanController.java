package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.TransaksiPenginapanControllerRoute;
import com.example.PortalDesa.model.TransaksiPenginapan;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.repository.TransaksiPenginapanRepo;
import com.example.PortalDesa.service.MailService;
import com.example.PortalDesa.service.TransaksiPenginapanService;
import com.example.PortalDesa.service.implement.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@RestController
@RequestMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN)
public class TransaksiPenginapanController {

    @Autowired
    TransaksiPenginapanService transaksiPenginapanService;

    @Autowired
    TransaksiPenginapanRepo transaksiPenginapanRepo;

    @Autowired
    StorageServiceImpl storageService;

    @Autowired
    MailService mailService;

    @PutMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_BAYAR_RESI)
    public ResponseEntity<?> update(@PathVariable String idPesanan, @RequestBody TransaksiPenginapan transaksiPenginapan) {
        transaksiPenginapanService.update(idPesanan, transaksiPenginapan.getSkuCustomer(), transaksiPenginapan.getResi());
        return ResponseEntity.ok(new DefaultResponse("update sukses", 200));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND__BY_SKU)
    public ResponseEntity<?> findTransaksi(@PathVariable String sku){
        return ResponseEntity.ok().body(transaksiPenginapanService.findById(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL)
    public ResponseEntity<?> findTransaksiPenginapanAll(){
        return ResponseEntity.ok().body(transaksiPenginapanRepo.findAll());
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_TERIMA_PESANAN)
    public ResponseEntity<?> terimaPesanan(@PathVariable String idPesanan) {
        transaksiPenginapanService.terimaPesanan(idPesanan);
        mailService.sendEmailPenginapan(idPesanan,1);
        return ResponseEntity.ok(new DefaultResponse("terima pesanan sukses", 200));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_TOLAK_PESANAN)
    public ResponseEntity<?> tolakPesanan(@PathVariable String idPesanan) {
        transaksiPenginapanService.tolakPesanan(idPesanan);
        mailService.sendEmailPenginapan(idPesanan,2);
        return ResponseEntity.ok(new DefaultResponse("tolak pesanan sukses", 200));
    }


    @PostMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_ADD)
    public ResponseEntity<?> add(@RequestBody TransaksiPenginapan transaksiPenginapan) {
        System.out.println(transaksiPenginapan);
        transaksiPenginapanService.save(transaksiPenginapan, 1);
        return ResponseEntity.ok(new DefaultResponse("Transaction Success", 200));
    }

    //WEB
    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_MASIH_PESAN_BY_SKU_WEB)
    public ResponseEntity<?> findAllPesananWeb(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllTransksiBySkuCustomerWeb(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_SUDAH_SELESAI_BY_SKU_WEB)
    public ResponseEntity<?> findAllPesananSelesaiWeb(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananSelesaiBySkuCustomerWeb(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_SUDAH_BAYAR_BY_SKU_WEB)
    public ResponseEntity<?> findAllPesananSudahBayarWeb(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananBayarBySkuCustomerWeb(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN_WEB)
    public ResponseEntity<?> findAllPesananWeb() {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllByStatusWeb(1));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN_SUDAH_BAYAR_WEB)
    public ResponseEntity<?> findAllPesananSudahBayarWeb() {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananBayarWeb());
    }




    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_MASIH_PESAN_BY_SKU)
    public ResponseEntity<?> findAllPesanan(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllTransksiBySkuCustomer(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_SUDAH_SELESAI_BY_SKU)
    public ResponseEntity<?> findAllPesananSelesai(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananSelesaiBySkuCustomer(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_SUDAH_BAYAR_BY_SKU)
    public ResponseEntity<?> findAllPesananSudahBayar(@PathVariable String sku) {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananBayarBySkuCustomer(sku));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN)
    public ResponseEntity<?> findAllPesanan() {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllByStatus(1));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_FIND_ALL_PESANAN_SUDAH_BAYAR)
    public ResponseEntity<?> findAllPesananSudahBayar() {
        return ResponseEntity.ok(transaksiPenginapanRepo.findAllPesananBayar());
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_CANCEL_PESANAN)
    public ResponseEntity<?> cancelPesanan(@PathVariable String sku) {
        transaksiPenginapanRepo.cancel(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses", 200));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_BALIKIN_PESANAN)
    public ResponseEntity<?> kembalikanPesanan(@PathVariable String sku) {
        transaksiPenginapanRepo.balikin(sku);
        return ResponseEntity.ok(new DefaultResponse("Cancel Pesanan Sukses", 200));
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_IMAGE_RESI)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("Resi", filePath), headers, HttpStatus.OK);
    }

    @GetMapping(TransaksiPenginapanControllerRoute.ROUTE_TRANSAKSI_PENGINAPAN_KIRIM_EMAIL)
    public ResponseEntity<?> sendEmail(@PathVariable String idPesanan) {
        mailService.sendEmail(idPesanan,1);
        return ResponseEntity.ok("Success");
    }
}
