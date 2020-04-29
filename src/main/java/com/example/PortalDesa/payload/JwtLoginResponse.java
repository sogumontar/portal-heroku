package com.example.PortalDesa.payload;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
@NoArgsConstructor
public class JwtLoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String role;
    private String skuLog;
    private Integer status;
    private String nickName;
    private String email;

    public JwtLoginResponse(String accessToken , String role) {
        this.accessToken = accessToken;
        this.role = role;
    }
    public JwtLoginResponse(String accessToken,  String role, String skuLog, Integer status, String nickName, String email) {
        this.accessToken = accessToken;
        this.role = role;
        this.skuLog = skuLog;
        this.status = status;
        this.nickName = nickName;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSkuLog() {
        return skuLog;
    }

    public void setSkuLog(String skuLog) {
        this.skuLog = skuLog;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
