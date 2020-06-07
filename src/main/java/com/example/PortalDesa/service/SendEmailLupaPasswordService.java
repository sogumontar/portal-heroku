package com.example.PortalDesa.service;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */
public interface SendEmailLupaPasswordService {
    public String  sendEmail(String email, String kode);
    public String  sendEmailNewPassword(String email, String newPassword);
}
