package com.example.PortalDesa.seeder;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.payload.request.RegisterRequest;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.seeder.data.Admin;
import com.example.PortalDesa.service.implement.AuthenticationServiceImpl;
import com.example.PortalDesa.service.implement.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
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
    public void seed(ContextRefreshedEvent contextRefreshedEvent) {
        checkIfExists("admin");
    }

}
