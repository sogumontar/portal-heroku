package com.example.PortalDesa.payload.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */
@NoArgsConstructor
@AllArgsConstructor
public class KodeLupaPasswordRequest {
    String kode;
    String username;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
