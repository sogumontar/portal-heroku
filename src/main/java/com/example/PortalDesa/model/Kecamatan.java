package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.FieldForTableKecamatan;
import com.example.PortalDesa.model.constant.TablesConstant;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 19/04/2020.
 */
@Entity
@Table(name = TablesConstant.TABLE_KECAMATAN)
public class Kecamatan {

    @Id
    String sku = UUID.randomUUID().toString();

    @Column(name = FieldForTableKecamatan.FIELD_FOTO_CAMAT)
    String fotoCamat;

    @Column(name = FieldForTableKecamatan.FIELD_GAMBAR_KECAMATAN)
    String gambarKecamatan;

    @Column(name = FieldForTableKecamatan.FIELD_NAMA)
    String nama;

    @Column(name = FieldForTableKecamatan.FIELD_NAMA_CAMAT)
    String namaCamat;

    public Kecamatan(String sku, String fotoCamat, String gambarKecamatan, String nama, String namaCamat) {
        this.sku = sku;
        this.fotoCamat = fotoCamat;
        this.gambarKecamatan = gambarKecamatan;
        this.nama = nama;
        this.namaCamat = namaCamat;
    }

    public Kecamatan() {

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getFotoCamat() {
        return fotoCamat;
    }

    public void setFotoCamat(String fotoCamat) {
        this.fotoCamat = fotoCamat;
    }

    public String getGambarKecamatan() {
        return gambarKecamatan;
    }

    public void setGambarKecamatan(String gambarKecamatan) {
        this.gambarKecamatan = gambarKecamatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaCamat() {
        return namaCamat;
    }

    public void setNamaCamat(String namaCamat) {
        this.namaCamat = namaCamat;
    }
}
