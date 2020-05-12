package com.example.PortalDesa.payload;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/05/2020.
 */
public class DefaultResponse {
    String message;
    Integer status;

    public DefaultResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
