package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.ProdukDesaControllerRoute;
import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.ProdukDesaRequest;
import com.example.PortalDesa.service.StorageService;
import com.example.PortalDesa.service.implement.ProdukDesaServiceImpl;
import com.example.PortalDesa.service.implement.StorageServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

    @Autowired
    private StorageServiceImpl storageService;

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(produkDesaService.findAll());
    }

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ALL_BY_SKU_DESA)
    public ResponseEntity<?> findALlBySkuDesa(@PathVariable String sku){
        return ResponseEntity.ok(produkDesaService.findAllBySkuDesa(sku));
    }

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_FIND_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        return ResponseEntity.ok(produkDesaService.findBySku(sku));
    }

    @PostMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ADD)
    public ResponseEntity<?> addProdukDesa(@RequestBody ProdukDesaRequest request) {
        produkDesaService.save(request);
        return ResponseEntity.ok(new DefaultResponse("Add Produk Success",200));
    }

    @PostMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_ADD_GAMBAR)
    public ResponseEntity<?> addGambarDesa(@RequestBody ProdukDesaRequest request){
        produkDesaService.addGambarDesa(request.getGambar(),request.getNama());
        return ResponseEntity.ok(new DefaultResponse("add gambar sukses",200));
    }

    @PostMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_UPDATE_GAMBAR)
    public ResponseEntity<?> updateGambarDesa(@RequestBody ProdukDesaRequest request){
        produkDesaService.updateGambarDesa(request.getGambar(),request.getNama());
        return ResponseEntity.ok(new DefaultResponse("add gambar sukses",200));
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_UPDATE)
    public ResponseEntity<?> updateProdukDesa(@RequestBody ProdukDesaRequest request, @PathVariable String sku) {
        produkDesaService.updateProduk(sku, request);
        return ResponseEntity.ok(new DefaultResponse("Update Produk Success",200));
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_UPDATE_WITH_GAMBAR)
    public ResponseEntity<?> updateProdukDesaWithGambar(@RequestBody ProdukDesaRequest request, @PathVariable String sku) {
        produkDesaService.updateProduk(sku, request);
        return ResponseEntity.ok(new DefaultResponse("Update Produk Success",200));
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_SUSPEND)
    public ResponseEntity<?> suspendProduk(@PathVariable String sku) {
        produkDesaService.suspendProduk(sku);
        return ResponseEntity.ok(new DefaultResponse("Suspend Produk Success",200));
    }

    @PutMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_DELETE)
    public ResponseEntity<?> deleteProduk(@PathVariable String sku) {
        produkDesaService.deleteProduk(sku);
        return ResponseEntity.ok(new DefaultResponse("Delete Produk Success",200));
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
        return ResponseEntity.ok(new DefaultResponse("Activate Success",200));
    }

    @GetMapping(ProdukDesaControllerRoute.ROUTE_PRODUK_DESA_IMAGE_GET_BY_NAME)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("ProdukDesa",filePath), headers, HttpStatus.OK);
    }
}
