package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.DesaControllerRoute;
import com.example.PortalDesa.model.defaults.KecamatanDefaults;
import com.example.PortalDesa.payload.request.DesaRequest;
import com.example.PortalDesa.repository.DesaRepo;
import com.example.PortalDesa.service.implement.DesaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/04/2020.
 */
@RestController
@RequestMapping(DesaControllerRoute.ROUTE_DESA_)
public class DesaController {

    @Autowired
    DesaRepo desaRepo;

    @Autowired
    DesaServiceImpl desaService;

    @GetMapping(DesaControllerRoute.ROUTE_DESA_ALL)
    public List findAll() {
        return desaRepo.findAll();
    }

    @GetMapping(DesaControllerRoute.ROUTE_DESA_FIND_BY_NAMA)
    public ResponseEntity<?> findByNama(@PathVariable String nama) {
        System.out.println(desaRepo.findFirstByNama(nama));
        return ResponseEntity.ok(desaRepo.findFirstByNama(nama));
    }

    @PostMapping(DesaControllerRoute.ROUTE_ADD_DESA)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addDesa(@RequestBody DesaRequest desaRequest) {
        return desaService.addDesa(desaRequest);
    }

    @GetMapping(DesaControllerRoute.ROUTE_FIND_BY_KECAMATAN)
    public ResponseEntity<?> findByKecamatan(@PathVariable KecamatanDefaults kecamatan){
        return ResponseEntity.ok(desaRepo.findAllByKecamatan(kecamatan));
    }

}
