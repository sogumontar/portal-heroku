package com.example.PortalDesa.seeder;

import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.model.Roles;
import com.example.PortalDesa.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */

@Component
public class RoleSeeder {
    @Autowired
    RoleRepo roleRepo;

    //cek apakah field sudah terdaftar
    public void checkRoleIfExists(RoleName roleName) {
        if (!roleRepo.existsByName(roleName)) {
            Roles roles = new Roles();
            roles.setName(roleName);
            saveRoles(roles);
        }
    }

    //simpan ke DB jika field belum ada
    public void saveRoles(Roles roles) {
        roleRepo.save(roles);
    }

    //pengecekan
    @EventListener
    public void seeder(ContextRefreshedEvent contextRefreshedEvent) {
        checkRoleIfExists(RoleName.ROLE_USER);
        checkRoleIfExists(RoleName.ROLE_ADMIN);
        checkRoleIfExists(RoleName.ROLE_MERCHANT);
    }

}
