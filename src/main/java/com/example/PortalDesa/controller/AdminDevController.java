package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.AdminDevControllerRoute;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.payload.request.DesaRequest;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import com.example.PortalDesa.service.implement.DesaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/04/2020.
 */
@RestController
@RequestMapping(AdminDevControllerRoute.ROUTE_FOOR_ADMIN_DEV)
public class AdminDevController {
    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    DesaServiceImpl desaService;

    @PostMapping(AdminDevControllerRoute.ROUTE_FOR_ADD_ADMIN_DESA)
    public ResponseEntity<?> createAdminDesa(@RequestBody DesaRequest desaRequest){
        System.out.println("Desa Request : " + desaRequest);
        RegisterRequest registerRequest= new RegisterRequest(
                desaRequest.getNama(),
                "desa" + desaRequest.getNama()+" kecamatan "+desaRequest.getKecamatan(),
                desaRequest.getUsername(),
                desaRequest.getEmail(),
                desaRequest.getPassword(),
                desaRequest.getConfirmPassword(),
                RoleName.ROLE_MERCHANT
        );
        authenticationService.register(registerRequest);
        return desaService.addDesa(desaRequest);
    }

    @PutMapping(AdminDevControllerRoute.ROUTE_UPDATE_DESA)
    public ResponseEntity<?> update(@PathVariable String sku, @RequestBody DesaRequest desaRequest ){
        desaService.updateDesa(sku,desaRequest);
        return ResponseEntity.ok(desaRequest);
    }
}
