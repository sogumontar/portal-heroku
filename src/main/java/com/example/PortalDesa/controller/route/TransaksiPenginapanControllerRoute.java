package com.example.PortalDesa.controller.route;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
public interface TransaksiPenginapanControllerRoute {
    //forAll
    public String ROUTE_TRANSAKSI_PENGINAPAN = "/transaksiPenginapan";


    public String ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL = "/";

    public String ROUTE_TRANSAKSI_PENGINAPAN_FIND__BY_SKU = "/sku/{sku}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_ADD = "/add";
    public String ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_SUDAH_BAYAR_BY_SKU = "/sku/bayar/{sku}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_FIND_ALL_MASIH_PESAN_BY_SKU = "/sku/pesan/{sku}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_BAYAR_RESI = "/bayar/{idPesanan}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_TERIMA_PESANAN = "/terima/{idPesanan}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_TOLAK_PESANAN = "/tolak/{idPesanan}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_IMAGE_RESI = "/get/{filePath}";
    public String ROUTE_TRANSAKSI_PENGINAPAN_KIRIM_EMAIL = "/kirim/email/{idPesanan}";

    public String ROUTE_TRANSAKSI_FIND_ALL_PESANAN = "/pesanan";
    public String ROUTE_TRANSAKSI_FIND_ALL_PESANAN_SUDAH_BAYAR = "/pesanan/sudah";
    public String ROUTE_TRANSAKSI_CANCEL_PESANAN = "/pesanan/cancel/{sku}";
    public String ROUTE_TRANSAKSI_BALIKIN_PESANAN = "/pesanan/balikin/{sku}";
}
