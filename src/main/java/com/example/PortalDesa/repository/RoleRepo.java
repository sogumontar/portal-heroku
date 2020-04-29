package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
    Boolean existsByName(RoleName roleName);
    Optional<Roles> findByName(RoleName roleName);
}
