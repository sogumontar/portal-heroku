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
    String desa;
    String gambar;

    public ProdukDesaRequest(String nama, Integer harga, String deskripsi, String desa, String gambar) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.desa = desa;
        this.gambar = gambar;
    }

    public ProdukDesaRequest(String nama, Integer harga, String deskripsi, String desa) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.desa = desa;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
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
