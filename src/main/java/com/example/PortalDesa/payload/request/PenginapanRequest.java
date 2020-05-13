package com.example.PortalDesa.payload.request;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@NoArgsConstructor
public class PenginapanRequest {
    String nama;
    Integer harga;
    String deskripsi;
    Integer jumlahKamar;
    String lokasi;
    String gambar;
    String desa;
    String kecamatan;
    String skumerchant;

    public PenginapanRequest(String nama, Integer harga, String deskripsi, Integer jumlahKamar, String lokasi, String desa, String kecamatan, String skuMerchant) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.jumlahKamar = jumlahKamar;
        this.lokasi = lokasi;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.skumerchant = skuMerchant;
    }


    public String getSkumerchant() {
        return skumerchant;
    }

    public void setSkumerchant(String skumerchant) {
        this.skumerchant = skumerchant;
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

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
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

    public Integer getJumlahKamar() {
        return jumlahKamar;
    }

    public void setJumlahKamar(Integer jumlahKamar) {
        this.jumlahKamar = jumlahKamar;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
