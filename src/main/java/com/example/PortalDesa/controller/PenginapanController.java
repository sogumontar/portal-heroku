package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.PenginapanControllerRoute;
import com.example.PortalDesa.payload.request.PenginapanRequest;
import com.example.PortalDesa.service.implement.PenginapanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@Controller
@CrossOrigin
@RequestMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN)
public class PenginapanController {
    @Autowired
    PenginapanServiceImpl penginapanService;

    @GetMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(penginapanService.findAll());
    }

    @GetMapping(PenginapanControllerRoute.ROUTE_PENGINAPAN_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku) {
        return ResponseEntity.ok(penginapanService.findBySku(sku));
    }

    @PostMapping(PenginapanControllerRoute.ROUTE_ADD_PENGINAPAN)
    public ResponseEntity<?> addPenginapan(@RequestBody PenginapanRequest penginapanRequest) {
        penginapanService.save(penginapanRequest);
        return ResponseEntity.ok("Add Penginapan Success");
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
        return ResponseEntity.ok("Delete Success");
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_DELETE_PENGINAPAN)
    public ResponseEntity<?> deleteBySku(@PathVariable String sku) {
        penginapanService.deleteBySku(sku);
        return ResponseEntity.ok("Delete Success");
    }

    @PutMapping(PenginapanControllerRoute.ROUTE_ACTIVATE_PENGINAPAN)
    public ResponseEntity<?> activatePenginapan(@PathVariable String sku){
        penginapanService.activate(sku);
        return ResponseEntity.ok("Activate Penginapan Success");
    }

}
