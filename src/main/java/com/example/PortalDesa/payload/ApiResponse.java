package com.example.PortalDesa.payload;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
public class ApiResponse {
    Boolean success;
    String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
