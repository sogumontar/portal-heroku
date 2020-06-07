package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForLupaPassword;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = TablesConstant.TABLE_LUPA_PASSWORD)
public class LupaPassword {
    @Id
    String id;

    @Column(name = FieldForLupaPassword.FIELD_SKU)
    String sku;

    @Column(name = FieldForLupaPassword.FIELD_KODE)
    String kode;

    @Column(name = FieldForLupaPassword.FIELD_DATE)
    String date;

    @Column(name = FieldForLupaPassword.FIELD_USERNAME)
    String username;

    public LupaPassword(String id, String sku, String kode, String date, String username) {
        this.id = id;
        this.sku = sku;
        this.kode = kode;
        this.date = date;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
