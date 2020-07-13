package com.example.PortalDesa.payload.request;

import com.example.PortalDesa.model.constant.FieldForTableKecamatan;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * Created by Sogumontar Hendra Simangunsong on 10/07/2020.
 */
@AllArgsConstructor
@NoArgsConstructor
public class KecamatanRequest {
    String gambarKecamatan;
    String nama;

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
}
