package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/05/2020.
 */
public interface ArtikelControllerRoute {
    //All
    String ROUTE_ARTIKEL = "/artikel";

    //For Web
    String ROUTE_ARTIKEL_ALL_FOR_WEB= "/web/";
    String ROUTE_ARTIKEL_ALL_BY_SKU_FOR_WEB = "/web/{sku}";
    String ROUTE_ARTIKEL_DETAIL_BY_ID_FOR_WEB = "/web/detail/{id}";

    //For Android
    String ROUTE_ARTIKEL_ALL= "/";
    String ROUTE_ARTIKEL_ALL_BY_SKU = "/{sku}";
    String ROUTE_ARTIKEL_DETAIL_BY_ID = "/detail/{id}";

    String ROUTE_ADD_ARTIKEL = "/add/{sku}";
    String ROUTE_UPDATE_ARTIKEL = "/update/{id}";
    String ROUTE_DELETE_ARTIKEL = "/delete/{id}";
}
