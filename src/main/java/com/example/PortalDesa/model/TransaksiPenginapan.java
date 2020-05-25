package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.*;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@NoArgsConstructor
@Entity
@Table(name = TablesConstant.TABLE_TRANSAKSI_PENGINAPAN)
public class TransaksiPenginapan {
    @Id
    String id = UUID.randomUUID().toString();

    @Column(name = FieldForTransaksiPenginapan.FIELD_SKU_PRODUK)
    String skuProduk;

    @Column(name = FieldForTransaksiPenginapan.FIELD_SKU_CUSTOMER)
    String skuCustomer;

    @Column(name = FieldForTransaksiPenginapan.FIELD_HARGA)
    Integer harga;

    @Column(name = FieldForTransaksiPenginapan.FIELD_METODE)
    String metode;

    @Column(name = FieldForTransaksiPenginapan.FIELD_LAMA_MENGINAP)
    Integer lamaMenginap;

    @Column(name = FieldForTransaksiPenginapan.FIELD_CHECK_IN)
    String checkin;

    @Column(name = FieldForTransaksiPenginapan.FIELD_RESI)
    String resi = PathImageDb.PATH_FOR_IMAGE_TRANSAKSI+"Default.jpg";

    @Column(name = FieldForTransaksiPenginapan.FIELD_STATUS)
    Integer status;

    @Column(name = FieldForTransaksiPenginapan.FIELD_KODE_PEMESANAN)
    String kodePemesanan;

    public TransaksiPenginapan(String id, String skuProduk, String skuCustomer, Integer harga, String metode, Integer lamaMenginap, String checkin, String resi, Integer status, String kodePemesanan) {
        this.id = id;
        this.skuProduk = skuProduk;
        this.skuCustomer = skuCustomer;
        this.harga = harga;
        this.metode = metode;
        this.lamaMenginap = lamaMenginap;
        this.checkin = checkin;
        this.resi = resi;
        this.status = status;
        this.kodePemesanan = kodePemesanan;
    }

    public String getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(String kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuProduk() {
        return skuProduk;
    }

    public void setSkuProduk(String skuProduk) {
        this.skuProduk = skuProduk;
    }

    public String getSkuCustomer() {
        return skuCustomer;
    }

    public void setSkuCustomer(String skuCustomer) {
        this.skuCustomer = skuCustomer;
    }


    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getMetode() {
        return metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public Integer getLamaMenginap() {
        return lamaMenginap;
    }

    public void setLamaMenginap(Integer lamaMenginap) {
        this.lamaMenginap = lamaMenginap;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}