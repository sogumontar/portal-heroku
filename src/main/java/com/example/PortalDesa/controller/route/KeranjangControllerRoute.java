package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
public interface KeranjangControllerRoute {
    public String ROUTE_KERANJANG = "/keranjang";

    public String ROUTE_KERANJANG_ALL = "/";
    public String ROUTE_KERANJANG_WITH_SKU_CUSTOMER = "/customer/{sku}";
    public String ROUTE_KERANJANG_WITH_SKU_MERCHANT = "/merchant/{sku}";
    public String ROUTE_KERANJANG_SAVE = "/save";
    public String ROUTE_KERANJANG_CHECK = "/check";
    public String ROUTE_KERANJANG_UPDATE = "/update";
    public String ROUTE_KERANJANG_DELETE = "/delete/{id}";

}
