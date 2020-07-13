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
    public String ROUTE_KECAMATAN_GET_IMAGE_BY_NAME = "/get/{filePath}";
    public String ROUTE_KECAMATAN_GET_BY_SKU = "/sku/{sku}";
    public String ROUTE_KECAMATAN_ADD_NEW = "/add";
    public String ROUTE_KECAMATAN_ADD_IMAGE = "/add/image";
    public String ROUTE_KECAMATAN_DELETE_BY_SKU = "/delete/{sku}";
}
