package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
public interface KeranjangControllerRoute {
    public String ROUTE_KERANJANG = "/keranjang";

    //For Android
    public String ROUTE_KERANJANG_ALL = "/";
    public String ROUTE_KERANJANG_WITH_SKU_CUSTOMER = "/customer/{sku}";
    public String ROUTE_KERANJANG_WITH_SKU_MERCHANT = "/merchant/{sku}";

    //For Web
    public String ROUTE_WEB_KERANJANG_ALL = "/web/";
    public String ROUTE_WEB_KERANJANG_WITH_SKU_CUSTOMER = "/web/customer/{sku}";
    public String ROUTE_WEB_KERANJANG_WITH_SKU_MERCHANT = "/web/merchant/{sku}";


    public String ROUTE_KERANJANG_SAVE = "/save";
    public String ROUTE_KERANJANG_CHECK = "/check";
    public String ROUTE_KERANJANG_UPDATE = "/update";
    public String ROUTE_KERANJANG_DELETE = "/delete/{id}";

}
