package com.example.PortalDesa.service;

import com.example.PortalDesa.model.DataTransaksi;
import com.example.PortalDesa.model.ProdukDesa;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */
@Service
public interface MailService {
    public String  sendEmail(String idPesanan, Integer indikator);
    public String  generateMessage(String idPesanan);
    public String  checkIndikator(String nama,Integer indikator);
    public String  generatePesanan(List<String> pesaanan);
    public DataTransaksi searchDataTransaksi(String idPesanan);
    public ProdukDesa getDetailProduk(String skuProduk);
}
