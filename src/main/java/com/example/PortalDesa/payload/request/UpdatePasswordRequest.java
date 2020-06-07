package com.example.PortalDesa.payload.request;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */
@NoArgsConstructor
public class UpdatePasswordRequest {
    String currentPassword;
    String newPassword;

    public UpdatePasswordRequest(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
