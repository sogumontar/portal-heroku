package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForTablePenginapan;
import com.example.PortalDesa.model.constant.PathImageDb;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 21/04/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = TablesConstant.TABLE_PENGINAPAN)
public class Penginapan {
    @Id
    String sku;

    @Column(name = FieldForTablePenginapan.FIELD_NAMA_PENGINAPAN)
    String nama;
    @Column(name = FieldForTablePenginapan.FIELD_HARGA_PENGINAPAN)
    Integer harga;
    @Column(name = FieldForTablePenginapan.FIELD_DESKRIPSI)
    String deskripsi;
    @Column(name = FieldForTablePenginapan.FIELD_JUMLAH_KAMAR)
    Integer jumlahKamar;
    @Column(name = FieldForTablePenginapan.FIELD_LOKASI_PENGINAPAN)
    String lokasi;
    @Column(name = FieldForTablePenginapan.FIELD_GAMBAR_PENGINAPAN)
    String gambar = PathImageDb.PATH_FOR_IMAGE_PENGINAPAN+"Default.jpg";
    @Column(name = FieldForTablePenginapan.FIELD_DESA)
    String desa;
    @Column(name = FieldForTablePenginapan.FIELD_KECAMATAN)
    String kecamatan;
    @Column(name = FieldForTablePenginapan.FIELD_STATUS)
    Integer status;

    public Penginapan(String sku, String nama, Integer harga, String deskripsi, Integer jumlahKamar, String lokasi, String gambar, String desa, String kecamatan, Integer status) {
        this.sku = sku;
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.jumlahKamar = jumlahKamar;
        this.lokasi = lokasi;
        this.gambar = gambar;
        this.desa = desa;
        this.kecamatan = kecamatan;
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
