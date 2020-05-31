package com.example.PortalDesa.seeder;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.seeder.data.Admin;
import com.example.PortalDesa.service.KecamatanService;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import com.example.PortalDesa.service.implement.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by Sogumontar Hendra Simangunsong on 26/04/2020.
 */
@Component
public class SeederAccount {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    KecamatanService kecamatanService;

    public void checkIfExists(String username) {
        if (!usersRepo.existsByUsername(username)) {
            RegisterRequest registerRequest = new RegisterRequest(
                    Admin.ADMIN_NAME,
                    Admin.ADMIN_ADDRESS,
                    Admin.ADMIN_USERNAME,
                    Admin.ADMIN_EMAIL,
                    Admin.ADMIN_PASSWORD,
                    Admin.ADMIN_PASSWORD,
                    Admin.ADMIN_ROLE
            );
            authenticationService.registerSeed(registerRequest);
        }
    }

    @EventListener
    public void seed(ContextRefreshedEvent contextRefreshedEvent) throws InterruptedException {
        checkIfExists("admin");
//        findAll();
    }

    @Async("threadPoolTaskExecutor")
    public ResponseEntity<?> findAll() throws InterruptedException {
        for(int i=0 ; i<10000000 ; i++){
            System.out.println("masuk");
            Thread.sleep(600 * 1000);
            System.out.println(kecamatanService.findAll());
        }
        return ResponseEntity.ok(kecamatanService.findAll());
    }

}
