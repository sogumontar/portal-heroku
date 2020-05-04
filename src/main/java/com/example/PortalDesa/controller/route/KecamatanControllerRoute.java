package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/04/2020.
 */
public interface KecamatanControllerRoute {
    //forAll
    public String ROUTE_KECAMATAN = "/kecamatan";


    public String ROUTE_KECAMATAN_ALL = "/";
    public String ROUTE_KECAMATAN_WITH_DESA = "/withDesa";
    public String ROUTE_KECAMATAN_GET_BY_NAME = "/{name}";
    public String ROUTE_KECAMATAN_GET_BY_SKU = "/sku/{sku}";
}
