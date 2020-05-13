package com.example.PortalDesa.payload.request;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@NoArgsConstructor
public class ProdukDesaRequest {
    String nama;
    Integer harga;
    String deskripsi;
    String gambar;
    String skuDesa;

    public ProdukDesaRequest(String nama, Integer harga, String deskripsi, String gambar, String skuDesa) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
        this.skuDesa = skuDesa;
    }

    public ProdukDesaRequest(String nama, Integer harga, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getSkuDesa() {
        return skuDesa;
    }

    public void setSkuDesa(String skuDesa) {
        this.skuDesa = skuDesa;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
