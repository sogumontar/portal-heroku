package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.model.UserRole;
import com.example.PortalDesa.model.defaults.RoleName;
import com.example.PortalDesa.seeder.RoleSeeder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Repository
public interface UsersRepo extends JpaRepository<Users, String> {
    Optional<Users> findByUsernameOrEmail(String email, String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Users findByUsername(String username);

    Users findFirstBySku(String sku);


    Boolean findFirstByUsername(String usename);

    @Query("  SELECT u FROM Users u , UserRole ur WHERE u.sku = ur.sku_user AND (ur.role_id = ?1)")
    List findAllByRoles(int val);

    @Modifying
    @Transactional
    @Query("UPDATE Users p  SET p.name=?2, p.email=?3, p.alamat=?4 WHERE p.sku LIKE ?1")
    Integer updateBysku(String sku, String name, String email, String almat);

    @Modifying
    @Transactional
    @Query("UPDATE Users p  SET p.password=?2 WHERE p.sku LIKE ?1")
    Integer updateByPassword(String sku, String password);

    @Modifying
    @Transactional
    @Query("UPDATE Users p  SET p.status=2 WHERE p.sku LIKE ?1")
    Integer suspendBysku(String sku);

    @Modifying
    @Transactional
    @Query("UPDATE Users p  SET p.status=1 WHERE p.sku LIKE ?1")
    Integer activateBysku(String sku);


}
