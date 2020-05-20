package com.example.PortalDesa.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@NoArgsConstructor
public class KeranjangRequestCheck {
    String id;
    String idProduk;
    String skuCustomer;
    Integer jumlah;


    public KeranjangRequestCheck(String id, String idProduk, String skuCustomer, Integer jumlah) {
        this.id = id;
        this.idProduk = idProduk;
        this.skuCustomer = skuCustomer;
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getSkuCustomer() {
        return skuCustomer;
    }

    public void setSkuCustomer(String skuCustomer) {
        this.skuCustomer = skuCustomer;
    }
}
