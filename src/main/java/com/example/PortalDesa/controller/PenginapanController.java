package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.PenginapanControllerRoute;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.PenginapanRequest;
import com.example.PortalDesa.service.StorageService;
import com.example.PortalDesa.service.implement.PenginapanServiceImpl;
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
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@Controller
@CrossOrigin
@RequestMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN)
public class PenginapanController {
    @Autowired
    PenginapanServiceImpl penginapanService;

    @Autowired
    StorageServiceImpl storageService;

    @GetMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(penginapanService.findAll());
    }

    @GetMapping(PenginapanControllerRoute.ROUTE_GET_ALL_BY_MERCHANT)
    public ResponseEntity<?> findAllBySkuMerchant(@PathVariable String sku) {
        return ResponseEntity.ok(penginapanService.findAllBySku(sku));
    }


    @GetMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        return ResponseEntity.ok(penginapanService.findBySku(sku));
    }

    @PostMapping(PenginapanControllerRoute.ROUTE_ADD_PENGINAPAN)
    public ResponseEntity<?> addPenginapan(@RequestBody PenginapanRequest penginapanRequest) {
        penginapanService.save(penginapanRequest);
        return ResponseEntity.ok(new DefaultResponse("Add Penginapan Success",200));
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_UPDATE)
    public ResponseEntity<?> updateBySku(@PathVariable String sku, @RequestBody PenginapanRequest penginapanRequest) {
        penginapanService.update(sku, penginapanRequest);
        return ResponseEntity.ok(penginapanRequest);
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_UPDATE_PENGINAPAN_WITH_GAMBAR)
    public ResponseEntity<?> updateWithGambarBySku(@PathVariable String sku, @RequestBody PenginapanRequest penginapanRequest) {
        penginapanService.updateWithGambar(sku, penginapanRequest);
        return ResponseEntity.ok(penginapanRequest);
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_SUSPEND_PENGINAPAN)
    public ResponseEntity<?> suspendBySku(@PathVariable String sku) {
        penginapanService.suspendBySku(sku);
        return ResponseEntity.ok(new DefaultResponse("Suspend Success",200));
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_DELETE_PENGINAPAN)
    public ResponseEntity<?> deleteBySku(@PathVariable String sku) {
        penginapanService.deleteBySku(sku);
        return ResponseEntity.ok(new DefaultResponse("Delete Success",200));
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_ACTIVATE_PENGINAPAN)
    public ResponseEntity<?> activatePenginapan(@PathVariable String sku){
        penginapanService.activate(sku);
        return ResponseEntity.ok(new DefaultResponse("Activate Penginapan Success",200));
    }
    @GetMapping(PenginapanControllerRoute.ROUTE_GET_IMAGE)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("Penginapan",filePath), headers, HttpStatus.OK);
    }
    @PostMapping(PenginapanControllerRoute.ROUTE_ADD_GAMBAR)
    public ResponseEntity<?> addGambarDesa(@RequestBody PenginapanRequest request){
        penginapanService.addGambarDesa(request.getGambar(),request.getNama());
        return ResponseEntity.ok(new DefaultResponse("Activate Gambar Success",200));
    }

    @PostMapping(PenginapanControllerRoute.ROUTE_ADD_GAMBAR)
    public ResponseEntity<?> updateGambarDesa(@RequestBody PenginapanRequest request){
        penginapanService.updateGambarDesa(request.getGambar(),request.getNama());
        return ResponseEntity.ok(new DefaultResponse("Update Gambar Success",200));
    }

}
