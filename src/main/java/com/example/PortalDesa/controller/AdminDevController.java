package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.AdminDevControllerRoute;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/04/2020.
 */
@RestController(AdminDevControllerRoute.ROUTE_FOOR_ADMIN_DEV)
public class AdminDevController {
    @Autowired
    AuthenticationServiceImpl authenticationService;

    @PostMapping(AdminDevControllerRoute.ROUTE_FOR_ADD_ADMIN_DESA)
    public ResponseEntity<?> createAdminDesa(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }
}
