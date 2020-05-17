package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.AuthenticationControllerRoute;
import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.LoginRequest;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.security.JwtTokenProvider;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import com.example.PortalDesa.service.implement.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    UsersRepo usersRepo;
    @GetMapping(AuthenticationControllerRoute.ROUTE_FIND_ALL)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(usersRepo.findAll());
    }

    @GetMapping(AuthenticationControllerRoute.ROUTE_FIND_BY_USERNAME)
    public Users findwithUsername(@PathVariable String username){
        return usersService.findByUsername(username);
    }

    @GetMapping(AuthenticationControllerRoute.ROUTE_FIND_BY_SKU)
    public Users findwithSku(@PathVariable String sku){
        return usersService.findBySku(sku);
    }

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_UP)
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        return authenticationService.register(registerRequest);
    }

    @PostMapping(AuthenticationControllerRoute.ROUTE_SIGN_IN)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PutMapping(AuthenticationControllerRoute.ROUTE_UPDATE_BY_SKU)
    public ResponseEntity<?> update( @RequestBody Users request, @PathVariable String sku) {
        if(authenticationService.updateUser(request,sku)){
            return ResponseEntity.ok(new DefaultResponse("Sku anda salah",201));
        }
        return ResponseEntity.badRequest().body(new DefaultResponse("Sku anda salah",400));
    }
}
