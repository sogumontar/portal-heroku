package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForAlamatCustomer;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = TablesConstant.TABLE_ALAMAT_CUSTOMER)
public class CustomerAddress {
    @Id
    String id=UUID.randomUUID().toString();

    @Column(name = FieldForAlamatCustomer.FIELD_SKU_CUSTOMER)
    String sku;

    @Column(name = FieldForAlamatCustomer.FIELD_ALAMAT_CUSTOMER)
    String alamat;

    public CustomerAddress(String sku, String alamat) {
        this.sku = sku;
        this.alamat = alamat;
    }

    public String getId() {
        return UUID.randomUUID().toString();
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
