package com.example.PortalDesa.service;

import com.example.PortalDesa.model.Users;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
public interface UsersService {

    public Users findByUsername(String username);

    public Users findBySku(String sku);

    public List findAllAccountCustomer();

    public List findAllAccountMerchant();

    public List findAllAccountAdmin();

    public Integer suspendAccount(String sku);

    public Integer activateAccount(String sku);

}
