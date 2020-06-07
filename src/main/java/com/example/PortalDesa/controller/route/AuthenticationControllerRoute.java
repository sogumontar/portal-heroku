package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 09/04/2020.
 */
public interface AuthenticationControllerRoute {
    //forAll
    public String ROUTE_AUTH= "/auth";


    public String ROUTE_SIGN_UP = "/signup";
    public String ROUTE_SIGN_IN = "/signin";
    public String ROUTE_FIND_BY_USERNAME = "/find/{username}";
    public String ROUTE_FIND_ALL = "/";
    public String ROUTE_FIND_BY_SKU = "/findSku/{sku}";
    public String ROUTE_UPDATE_BY_SKU = "/update/{sku}";
    public String ROUTE_UPDATE_PASSWORD_BY_SKU = "/updatePassword/{sku}";
    public String ROUTE_FORGET_PASSWORD_BY_SKU = "/forgetPassword/{username}";
    public String ROUTE_CHECK_CODE_FOR_LUPA_PASSWORD = "/checkCode";
}
