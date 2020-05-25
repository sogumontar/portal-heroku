package com.example.PortalDesa.model;

import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@NoArgsConstructor
public class DataTransaksiPnginapan {
    private String skuCustomer;
    private String skuProduk;
    private String email;
    private String nama;
    private String checkin;
    private Integer lamaMenginap;
    private Integer hargaTotal;
    private String  kodeTransaksi;
    private String  metode;


    public DataTransaksiPnginapan(String skuCustomer, String skuProduk, String email, String nama, String checkin, Integer lamaMenginap, Integer hargaTotal, String kodeTransaksi, String metode) {
        this.skuCustomer = skuCustomer;
        this.skuProduk = skuProduk;
        this.email = email;
        this.nama = nama;
        this.checkin = checkin;
        this.lamaMenginap = lamaMenginap;
        this.hargaTotal = hargaTotal;
        this.kodeTransaksi = kodeTransaksi;
        this.metode = metode;
    }

    public String getSkuCustomer() {
        return skuCustomer;
    }

    public void setSkuCustomer(String skuCustomer) {
        this.skuCustomer = skuCustomer;
    }

    public String getSkuProduk() {
        return skuProduk;
    }

    public void setSkuProduk(String skuProduk) {
        this.skuProduk = skuProduk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public Integer getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(Integer lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }

    public Integer getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(Integer hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }
}
