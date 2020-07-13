package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.DesaControllerRoute;
import com.example.PortalDesa.controller.route.KecamatanControllerRoute;
import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.AddDesaPictureRequest;
import com.example.PortalDesa.payload.request.KecamatanRequest;
import com.example.PortalDesa.repository.KecamatanRepo;
import com.example.PortalDesa.service.StorageService;
import com.example.PortalDesa.service.implement.KecamatanServiceImpl;
import com.example.PortalDesa.service.implement.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@CrossOrigin
@Controller
@RequestMapping(KecamatanControllerRoute.ROUTE_KECAMATAN)
public class KecamatanController {
    @Autowired
    KecamatanServiceImpl kecamatanService;

    @Autowired
    StorageServiceImpl storageService;

    @GetMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_ALL)
    public ResponseEntity<?> findAll(){
        System.out.println(kecamatanService.findAll());
        return ResponseEntity.ok(kecamatanService.findAll());
    }

    @GetMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_WITH_DESA)
    public ResponseEntity<?> findAllWithDesa(){
        System.out.println(kecamatanService.findAllWithDesa());
        return ResponseEntity.ok(kecamatanService.findAllWithDesa());
    }
    @GetMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_GET_BY_NAME)
    public ResponseEntity<?> findByName(@PathVariable String name){
        return ResponseEntity.ok(kecamatanService.findFirstByNama(name));
    }
    @GetMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_GET_IMAGE_BY_NAME)
    public ResponseEntity<byte[]> getImage(@PathVariable String filePath) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(storageService.loadImage("Kecamatan",filePath), headers, HttpStatus.OK);
    }

    @PostMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_ADD_NEW)
    public ResponseEntity<?> addNewKecamatan(@RequestBody KecamatanRequest kecamatanRequest) throws IOException {
        kecamatanService.addNewKecamatan(kecamatanRequest);
        return ResponseEntity.ok().body(new DefaultResponse("Sukses",201));
    }

    @PutMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_ADD_IMAGE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addDesaPicture(@RequestBody AddDesaPictureRequest addDesaPictureRequest) throws IOException {
        kecamatanService.addImage(addDesaPictureRequest.getBase64File(),addDesaPictureRequest.getSkuDesa());
        return ResponseEntity.ok("");
    }

    @GetMapping(KecamatanControllerRoute.ROUTE_KECAMATAN_DELETE_BY_SKU)
    public ResponseEntity<?> deleteBySku(@PathVariable String sku){
        kecamatanService.deleteBySku(sku);
        return ResponseEntity.ok().body(new DefaultResponse("Sukses",200));
    }



}
