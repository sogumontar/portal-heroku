package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Users;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
public interface UsersService {
    public Users findByUsername(String username);
}
