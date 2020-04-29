package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.ProdukDesaControllerRoute;
import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.payload.request.ProdukDesaRequest;
import com.example.PortalDesa.service.implement.ProdukDesaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@CrossOrigin
@Controller
@RequestMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA)
public class ProdukDesaController {
    @Autowired
    ProdukDesaServiceImpl produkDesaService;

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(produkDesaService.findAll());
    }

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_FIND_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        return ResponseEntity.ok(produkDesaService.findBySku(sku));
    }

    @PostMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ADD)
    public ResponseEntity<?> addProdukDesa(@RequestBody ProdukDesaRequest request) {
        produkDesaService.save(request);
        return ResponseEntity.ok("Add Produk Success");
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_UPDATE)
    public ResponseEntity<?> updateProdukDesa(@RequestBody ProdukDesaRequest request, @PathVariable String sku) {
        produkDesaService.updateProduk(sku, request);
        return ResponseEntity.ok("Update Produk Success");
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_UPDATE_WITH_GAMBAR)
    public ResponseEntity<?> updateProdukDesaWithGambar(@RequestBody ProdukDesaRequest request, @PathVariable String sku) {
        produkDesaService.updateProduk(sku, request);
        return ResponseEntity.ok("Update Produk Success");
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_SUSPEND)
    public ResponseEntity<?> suspendProduk(@PathVariable String sku) {
        produkDesaService.suspendProduk(sku);
        return ResponseEntity.ok("Suspend Produk Success");
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_DELETE)
    public ResponseEntity<?> deleteProduk(@PathVariable String sku) {
        produkDesaService.deleteProduk(sku);
        return ResponseEntity.ok("Delete Produk Success");
    }

    @CrossOrigin
    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ALL_SUSPEND)
    public ResponseEntity<?> findAllSuspend() {
        System.out.println("masuk");
        return ResponseEntity.ok(produkDesaService.findAllSuspend());
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ACTIVATE_BY_SKU)
    public ResponseEntity<?> activate(@PathVariable String sku) {
        produkDesaService.activate(sku);
        return ResponseEntity.ok("Activate Success");
    }

}
