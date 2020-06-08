package com.example.PortalDesa.service;

import com.example.PortalDesa.model.DataTransaksi;
import com.example.PortalDesa.model.DataTransaksiPnginapan;
import com.example.PortalDesa.model.Penginapan;
import com.example.PortalDesa.model.ProdukDesa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public interface MailService {
    public String  sendEmail(String idPesanan, Integer indikator);
    public String  sendEmailPesanan(String metode, String alamat,Integer harga, String email);
    public String  sendEmailPenginapan(String idPesanan, Integer indikator);
    public String  generateMessage(String idPesanan);
    public String  checkIndikator(String nama,Integer indikator);
    public String  generatePesanan(List<String> pesaanan);
    public DataTransaksi searchDataTransaksi(String idPesanan);
    public DataTransaksiPnginapan searchDataTransaksiPenginapan(String idPesanan);
    public ProdukDesa getDetailProduk(String skuProduk);
    public Penginapan getDetailPenginapan(String skuProduk);
    public String generateKodePemesanan(String idPesanan,String random);
}
