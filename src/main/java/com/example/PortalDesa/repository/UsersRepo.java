package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.model.UserRole;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.seeder.RoleSeeder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Repository
public interface UsersRepo  extends JpaRepository<Users,String> {
    Optional<Users> findByUsernameOrEmail(String email, String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users findByUsername(String username);
    Users findFirstBySku(String sku);
    @Query("  SELECT u FROM Users u , UserRole ur WHERE u.sku = ur.sku_user AND (ur.role_id = ?1)")
    List findAllByRoles(int val);
}
