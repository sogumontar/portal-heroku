package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForArticle;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = TablesConstant.TABLE_ARTIKEL)
public class Artikel {
    @Id
    String id;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_JUDUL)
    String judul;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_DATE)
    String date;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_JENIS)
    String jenis;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_ISI, length=10485760)
    String isi;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_SUMBER)
    String sumber;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_PENULIS)
    String penulis;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_SKU_ADMIN_DESA)
    String skuAdmin;

    @Column(name = FieldForArticle.FIELD_ARTIKEL_STATUS)
    Integer status;

    public Artikel(String id, String judul, String date, String jenis, String isi, String sumber, String penulis, String skuAdmin, Integer status) {
        this.id = id;
        this.judul = judul;
        this.date = date;
        this.jenis = jenis;
        this.isi = isi;
        this.sumber = sumber;
        this.penulis = penulis;
        this.skuAdmin = skuAdmin;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSkuAdmin() {
        return skuAdmin;
    }

    public void setSkuAdmin(String skuAdmin) {
        this.skuAdmin = skuAdmin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
}
