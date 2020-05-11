package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForTransaksi;
import com.example.PortalDesa.model.constant.PathImageDb;
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
@NoArgsConstructor
@Entity
@Table(name = TablesConstant.TABLE_TRANSAKSI_PRODUK)
public class TransaksiProduk {
    @Id
    String id = UUID.randomUUID().toString();

    @Column(name = FieldForTransaksi.FIELD_SKU_PRODUK)
    String skuProduk;

    @Column(name = FieldForTransaksi.FIELD_SKU_CUSTOMER)
    String skuCustomer;

    @Column(name = FieldForTransaksi.FIELD_ALAMAT)
    String alamat;

    @Column(name = FieldForTransaksi.FIELD_HARGA)
    Integer harga;

    @Column(name = FieldForTransaksi.FIELD_METODE)
    String metode;

    @Column(name = FieldForTransaksi.FIELD_RESI)
    String resi = PathImageDb.PATH_FOR_IMAGE_TRANSAKSI+"Default.jpg";

    @Column(name = FieldForTransaksi.FIELD_STATUS)
    Integer status;

    public TransaksiProduk( String skuProduk, String skuCustomer, String alamat, Integer harga, String metode, Integer status) {
        this.skuProduk = skuProduk;
        this.skuCustomer = skuCustomer;
        this.alamat = alamat;
        this.harga = harga;
        this.metode = metode;
        this.status = status;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
