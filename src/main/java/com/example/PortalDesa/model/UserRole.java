package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.TablesConstant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/04/2020.
 */
@Entity
@Table(name = TablesConstant.TABEL_USER_ROLE)
public class UserRole  {
    @Id
    public String sku_user;

    private Integer role_id;

    public UserRole() {
    }

    public UserRole(String sku_user, Integer role_id) {
        this.sku_user = sku_user;
        this.role_id = role_id;
    }

    public String getSku_user() {
        return sku_user;
    }

    public void setSku_user(String sku_user) {
        this.sku_user = sku_user;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
