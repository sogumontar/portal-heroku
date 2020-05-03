package com.example.PortalDesa.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by Sogumontar Hendra Simangunsong on 16/04/2020.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesaRequest {

    @NotNull
    public String nama;

    @NotNull
    public String namaKepalaDesa;

    @NotNull
    public int jumlahPenduduk;

    @NotNull
    public String kecamatan;

    @NotNull
    public String gambar;

    public String username;
    @Email
    public String email;

    public String password;

    public String confirmPassword;

    public DesaRequest(@NotNull String nama, @NotNull String kecamatan,  String username, @Email String email, String password, String confirmPassword) {
        this.nama = nama;
        this.kecamatan = kecamatan;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword=confirmPassword;
    }

    public DesaRequest(@NotNull String nama, @NotNull String namaKepalaDesa, @NotNull int jumlahPenduduk, @NotNull String kecamatan, @NotNull String gambar) {
        this.nama = nama;
        this.namaKepalaDesa = namaKepalaDesa;
        this.jumlahPenduduk = jumlahPenduduk;
        this.kecamatan = kecamatan;
        this.gambar = gambar;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaKepalaDesa() {
        return namaKepalaDesa;
    }

    public void setNamaKepalaDesa(String namaKepalaDesa) {
        this.namaKepalaDesa = namaKepalaDesa;
    }

    public int getJumlahPenduduk() {
        return jumlahPenduduk;
    }

    public void setJumlahPenduduk(int jumlahPenduduk) {
        this.jumlahPenduduk = jumlahPenduduk;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
