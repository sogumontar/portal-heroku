package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.CustomerControllerRoute;
import com.example.PortalDesa.model.CustomerAddress;
import com.example.PortalDesa.repository.AlamatCustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Controller
@RequestMapping(CustomerControllerRoute.ROUTE_FOR_CUSTOMER_CONTROLLER)
public class CustomerController {
    @Autowired
    AlamatCustomerRepo alamatCustomerRepo;

    @GetMapping(CustomerControllerRoute.ROUTE_FOR_CUSTOMER_CONTROLLER_FIND_ALL)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(alamatCustomerRepo.findAll());
    }

    @GetMapping(CustomerControllerRoute.ROUTE_FOR_CUSTOMER_CONTROLLER_FIND_ALL_BY_SKU)
    public ResponseEntity<?> findBySku(@PathVariable String sku){
        return ResponseEntity.ok(alamatCustomerRepo.findFirstBySku(sku));
    }

    @PostMapping(CustomerControllerRoute.ROUTE_FOR_CUSTOMER_CONTROLLER_ADD)
    public ResponseEntity<?> add(@RequestBody CustomerAddress customerAddress){
        return ResponseEntity.ok(alamatCustomerRepo.save(customerAddress));
    }

    @PutMapping(CustomerControllerRoute.ROUTE_FOR_CUSTOMER_CONTROLLER_UPDATE_BY_SKU)
    public ResponseEntity<?> update(@PathVariable String sku ,@RequestBody CustomerAddress customerAddress){
        alamatCustomerRepo.update(customerAddress.getAlamat(),customerAddress.getSku());
        return ResponseEntity.ok("Update Success");
    }
}
