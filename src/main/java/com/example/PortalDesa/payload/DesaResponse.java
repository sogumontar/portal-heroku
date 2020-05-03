package com.example.PortalDesa.payload;

import com.example.PortalDesa.model.Desa;

/**
 * Created by Sogumontar Hendra Simangunsong on 02/05/2020.
 */
public class DesaResponse {
    String message ;
    Desa data;

    public DesaResponse(String message, Desa data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Desa getData() {
        return data;
    }

    public void setData(Desa data) {
        this.data = data;
    }
}
