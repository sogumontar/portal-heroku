package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.repository.UsersRepo;
import com.example.PortalDesa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepo usersRepo;

    @Override
    public Users findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    @Override
    public List findAllAccountCustomer() {
        return usersRepo.findAllByRoles(1);
    }

    @Override
    public List findAllAccountMerchant() {
        return usersRepo.findAllByRoles(3);
    }

    @Override
    public List findAllAccountAdmin() {
       return usersRepo.findAllByRoles(2);
    }
}
