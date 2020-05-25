package com.example.PortalDesa.payload.request;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 03/05/2020.
 */
@NoArgsConstructor
public class AddDesaPictureRequest {
    public String base64File;
    public String skuDesa;

    public AddDesaPictureRequest(String base64File, String skuDesa) {
        this.base64File = base64File;
        this.skuDesa = skuDesa;
    }

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public String getSkuDesa() {
        return skuDesa;
    }

    public void setSkuDesa(String skuDesa) {
        this.skuDesa = skuDesa;
    }
}
