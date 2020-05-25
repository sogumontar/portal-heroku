package com.example.PortalDesa.model;

import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 24/05/2020.
 */
@NoArgsConstructor
public class DataTransaksi {
    private String skuCustomer;
    private List<String> skuProduk;
    private String email;
    private String nama;
    private Integer hargaTotal;
    private String  alamat;
    private String  metode;



    public DataTransaksi(String skuCustomer, List<String> skuProduk, String email, String nama, Integer hargaTotal, String alamat, String metode) {
        this.skuCustomer = skuCustomer;
        this.skuProduk = skuProduk;
        this.email = email;
        this.nama = nama;
        this.hargaTotal = hargaTotal;
        this.alamat = alamat;
        this.metode = metode;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSkuCustomer() {
        return skuCustomer;
    }

    public void setSkuCustomer(String skuCustomer) {
        this.skuCustomer = skuCustomer;
    }

    public List<String> getSkuProduk() {
        return skuProduk;
    }

    public void setSkuProduk(List<String> skuProduk) {
        this.skuProduk = skuProduk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(Integer hargaTotal) {
        this.hargaTotal = hargaTotal;
    }
}
