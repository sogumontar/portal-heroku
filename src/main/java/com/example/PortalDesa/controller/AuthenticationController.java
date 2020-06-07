package com.example.PortalDesa.controller;

import com.example.PortalDesa.controller.route.AuthenticationControllerRoute;
import com.example.PortalDesa.model.LupaPassword;
import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.payload.DefaultResponse;
import com.example.PortalDesa.payload.request.KodeLupaPasswordRequest;
import com.example.PortalDesa.payload.request.LoginRequest;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.payload.request.UpdatePasswordRequest;
import com.example.PortalDesa.repository.LupaPasswordRepo;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.security.JwtTokenProvider;
import com.example.PortalDesa.service.SendEmailLupaPasswordService;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import com.example.PortalDesa.service.implement.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@CrossOrigin
@RestController
@RequestMapping(AuthenticationControllerRoute.ROUTE_AUTH)
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;

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

    @Autowired
    LupaPasswordRepo lupaPasswordRepo;

    @Autowired
    SendEmailLupaPasswordService sendEmailLupaPasswordService;

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
            return ResponseEntity.ok(new DefaultResponse("Sukses",201));
        }
        return ResponseEntity.ok().body(new DefaultResponse("Sku anda salah",400));
    }

    @PutMapping(AuthenticationControllerRoute.ROUTE_UPDATE_PASSWORD_BY_SKU)
    public ResponseEntity<?> updatePassword(@RequestBody UpdatePasswordRequest request, @PathVariable String sku) {
        Users  users = usersRepo.findFirstBySku(sku);
        if(BCrypt.checkpw(request.getCurrentPassword(),users.getPassword())){
            if(usersRepo.updateByPassword( sku,passwordEncoder.encode(request.getNewPassword()))==1){
                return ResponseEntity.ok(new DefaultResponse("Sukses",200));
            }
        }
        return ResponseEntity.ok().body(new DefaultResponse("Password lama anda salah",400));
    }

    @GetMapping(AuthenticationControllerRoute.ROUTE_FORGET_PASSWORD_BY_SKU)
    public ResponseEntity<?> forgotPassword(@PathVariable String username) {
        Users users= usersRepo.findByUsername(username);
        String randKode=UUID.randomUUID().toString();
        String date = LocalDate.now().toString();
        if(usersRepo.findByUsername(username)!=null){
            LupaPassword lupaPassword= new LupaPassword(
                    UUID.randomUUID().toString(),
                    users.getSku(),
                    randKode,
                    date,
                    username
            );
            sendEmailLupaPasswordService.sendEmail(users.getEmail(), randKode);
            lupaPasswordRepo.save(lupaPassword);
            return ResponseEntity.ok().body(new DefaultResponse("Send Kode Lupa Password Success",200));
        }
        return ResponseEntity.ok().body(new DefaultResponse("Username Tidak Terdaftar",400));
    }

    @PostMapping(AuthenticationControllerRoute.ROUTE_CHECK_CODE_FOR_LUPA_PASSWORD)
    public ResponseEntity<?> checkCode(@RequestBody KodeLupaPasswordRequest request) {
        Users users= usersRepo.findByUsername(request.getUsername());
        String randPassword =UUID.randomUUID().toString();
        if(users!=null) {
            if (lupaPasswordRepo.findByUsernameAndKodeAndDate(request.getUsername(), request.getKode(), LocalDate.now().toString())!=null) {
                sendEmailLupaPasswordService.sendEmailNewPassword(users.getEmail(), randPassword);
                usersRepo.updateByPassword(users.getSku(), passwordEncoder.encode(randPassword));
                return ResponseEntity.ok().body(new DefaultResponse("Set New Password Success", 200));
            }
            return ResponseEntity.ok().body(new DefaultResponse("Kode tidak dikenali", 400));
        }
        return ResponseEntity.ok().body(new DefaultResponse("Username Tidak Terdaftar", 402));
    }
}
