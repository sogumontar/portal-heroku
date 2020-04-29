package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,String> {
    @Query("select u from UserRole u where u.sku_user LIKE ?1")
    UserRole findFirstBySku_user(String sku_user);
}
