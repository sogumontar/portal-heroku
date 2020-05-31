package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.ArtikelControllerRoute;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.ArtikelRequest;
import com.example.PortalDesa.repository.ArtikelRepo;
import com.example.PortalDesa.service.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@RestController
@RequestMapping(ArtikelControllerRoute.ROUTE_ARTIKEL)
public class ArtikelController {

    @Autowired
    ArtikelService artikelService;

    @Autowired
    ArtikelRepo artikelRepo;

    //For Web
    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL_FOR_WEB)
    public ResponseEntity<?> findAllForWeb() {
        return ResponseEntity.ok(artikelRepo.findAllForWeb());
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_BY_SKU_FOR_WEB)
    public ResponseEntity<?> findAllArtikelForWeb(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Artikel",sku));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL_BERITA_BY_SKU_FOR_WEB)
    public ResponseEntity<?> findAllBeritaForWeb(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Berita",sku));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL_PENGUMUMAN_BY_SKU_FOR_WEB)
    public ResponseEntity<?> findAllPengumumanForWeb(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Pengumuman",sku));
    }


    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL_BY_SKU_FOR_WEB)
    public ResponseEntity<?> findAllBySkuForWeb(@PathVariable String sku){
        return ResponseEntity.ok(artikelService.findAllArtikelBySkuForWeb(sku));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_DETAIL_BY_ID_FOR_WEB)
    public ResponseEntity<?> findDetailByIdForWeb(@PathVariable String id){
        return ResponseEntity.ok(artikelService.findDetailArtikelByIdForWeb(id));
    }


    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ARTIEKL_ALL)
    public ResponseEntity<?> artikelFindAll() {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Artikel"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_BERITA_ALL)
    public ResponseEntity<?> beritaFindAll() {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Berita"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_PENGUMUMAN_ALL)
    public ResponseEntity<?> pengumumanFindAll() {
        return ResponseEntity.ok(artikelRepo.findAllByJenis("Pengumuman"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(artikelRepo.findAll());
    }


    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_ALL_BY_SKU)
    public ResponseEntity<?> findAllBySku(@PathVariable String sku) {
        return ResponseEntity.ok(artikelService.findAllArtikelBySku(sku));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_BY_SKU)
    public ResponseEntity<?> findAllArtikelsBySku(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllBySkuAdminAndJenis(sku,"Artikel"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_BERITA_ALL_BY_SKU)
    public ResponseEntity<?> findAllBeritasBySku(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllBySkuAdminAndJenis(sku,"Berita"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_PENGUMUMAN_ALL_BY_SKU)
    public ResponseEntity<?> findAllPengumumanBySku(@PathVariable String sku) {
        return ResponseEntity.ok(artikelRepo.findAllBySkuAdminAndJenis(sku,"Pengumuman"));
    }

    @GetMapping(ArtikelControllerRoute.ROUTE_ARTIKEL_DETAIL_BY_ID)
    public ResponseEntity<?> findDetailById(@PathVariable String id) {
        return ResponseEntity.ok(artikelService.findDetailArtikelById(id));
    }

    @PostMapping(ArtikelControllerRoute.ROUTE_ADD_ARTIKEL)
    public ResponseEntity<?> add(@PathVariable String sku, @RequestBody ArtikelRequest artikelRequest) {
        return ResponseEntity.ok(artikelService.save(sku, artikelRequest));
    }

    @PutMapping(ArtikelControllerRoute.ROUTE_UPDATE_ARTIKEL)
    public ResponseEntity<?> updateById(@PathVariable String id, @RequestBody ArtikelRequest artikelRequest) {
        return ResponseEntity.ok(artikelService.update(id, artikelRequest));
    }

    @DeleteMapping(ArtikelControllerRoute.ROUTE_DELETE_ARTIKEL)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        artikelService.delete(id);
        return ResponseEntity.ok(new DefaultResponse("Delete Success", 200));
    }

}
