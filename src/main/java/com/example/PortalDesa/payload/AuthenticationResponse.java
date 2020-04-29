package com.example.PortalDesa.payload;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@Builder
@NoArgsConstructor
public class AuthenticationResponse {
    String timestamp;
    String code;
    String status;
    String message;

    public AuthenticationResponse(String timestamp, String code, String status, String message) {
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
