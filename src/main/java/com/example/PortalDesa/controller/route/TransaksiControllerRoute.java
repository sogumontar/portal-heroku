package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 05/05/2020.
 */
public interface TransaksiControllerRoute {
    //forAll
    public String ROUTE_TRANSAKSI = "/transaksi";


    public String ROUTE_TRANSAKSI_FIND_ALL = "/";

    public String ROUTE_TRANSAKSI_FIND_ALL_BY_SKU = "/sku/{sku}";
    public String ROUTE_TRANSAKSI_ADD = "/add";
    public String ROUTE_TRANSAKSI_ADD_CART = "/add/cart";
    public String ROUTE_TRANSAKSI_FIND_ALL_CART_BY_SKU = "/sku/cart/{sku}";
    public String ROUTE_TRANSAKSI_FIND_ALL_SUDAH_BAYAR_BY_SKU = "/sku/bayar/{sku}";
    public String ROUTE_TRANSAKSI_FIND_ALL_MASIH_PESAN_BY_SKU = "/sku/pesan/{sku}";
    public String ROUTE_TRANSAKSI_BAYAR_RESI = "/bayar/{idPesanan}";
    public String ROUTE_TRANSAKSI_IMAGE_RESI = "/get/{filePath}";

    public String ROUTE_TRANSAKSI_FIND_ALL_PESANAN = "/pesanan";

}
