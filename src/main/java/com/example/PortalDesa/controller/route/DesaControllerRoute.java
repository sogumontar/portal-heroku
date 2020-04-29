package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/04/2020.
 */
public interface DesaControllerRoute {
    //forAll
    public String ROUTE_DESA_ = "/desa";


    public String ROUTE_DESA_ALL = "/";
    public String ROUTE_DESA_FIND_BY_NAMA = "/{nama}";
    public String ROUTE_ADD_DESA = "/add";
    public String ROUTE_FIND_BY_KECAMATAN = "/kecamatan/{kecamatan}";
}
