package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.LupaPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */
@Repository
public interface LupaPasswordRepo extends JpaRepository<LupaPassword,String> {
    LupaPassword findByUsernameAndKodeAndDate(String username,String kode,String date);
}
