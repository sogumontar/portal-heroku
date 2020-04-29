package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Roles;
import com.example.PortalDesa.payload.request.LoginRequest;
import com.example.PortalDesa.payload.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
public interface AuthenticationService {
    ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest);
    void registerSeed(@RequestBody RegisterRequest registerRequest);

    ResponseEntity<?> login(@RequestBody LoginRequest loginRequest);

    Roles checkRole(String role);

    String skuGenerator(String Username, String role);

    ResponseEntity<?> checkUsername(String username);

    ResponseEntity<?> checkEmail(String email);

    String sub_str(String str);

    Boolean checkPassword(String password, String confirmPassword);
}