package com.example.PortalDesa.payload.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
@NoArgsConstructor
public class ArtikelRequest {
    String judul;

    String jenis;

    String isi;

    String sumber;

    String penulis;

    public ArtikelRequest(String judul, String jenis, String isi, String sumber, String penulis) {
        this.judul = judul;
        this.jenis = jenis;
        this.isi = isi;
        this.sumber = sumber;
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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
