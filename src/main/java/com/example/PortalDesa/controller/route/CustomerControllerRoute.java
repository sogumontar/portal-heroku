package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
public interface CustomerControllerRoute {
    String ROUTE_FOR_CUSTOMER_CONTROLLER= "/customer";
    String ROUTE_FOR_CUSTOMER_CONTROLLER_FIND_ALL_BY_SKU= "/{sku}";
    String ROUTE_FOR_CUSTOMER_CONTROLLER_FIND_ALL= "/";
    String ROUTE_FOR_CUSTOMER_CONTROLLER_ADD= "/add";
    String ROUTE_FOR_CUSTOMER_CONTROLLER_UPDATE_BY_SKU= "/update/{sku}";
}
