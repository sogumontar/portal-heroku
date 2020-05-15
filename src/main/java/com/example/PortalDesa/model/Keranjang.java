package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForKeranjang;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TablesConstant.TABLE_KERANJANG)
public class Keranjang {

    @Id
    String id = UUID.randomUUID().toString();

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_ID_CUSTOMER)
    String idCustomer;

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_ID_PRODUK)
    String idProduk;

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_JUMLAH)
    Integer jumlah;

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_SKU_DESA)
    String skuDesa;

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_STATUS)
    Integer status;

    @Column(name = FieldForKeranjang.FIELD_KERANJANG_HARGA)
    Integer harga;

    public Keranjang( String idCustomer, String idProduk, Integer jumlah, String skuDesa, Integer status, Integer harga) {
        this.idCustomer = idCustomer;
        this.idProduk = idProduk;
        this.jumlah = jumlah;
        this.skuDesa = skuDesa;
        this.status = status;
        this.harga=harga;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getSkuDesa() {
        return skuDesa;
    }

    public void setSkuDesa(String skuDesa) {
        this.skuDesa = skuDesa;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
