package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.DataTransaksi;
import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.model.Users;
import com.example.PortalDesa.model.defaults.MailDefaults;
import com.example.PortalDesa.service.MailService;
import com.example.PortalDesa.service.ProdukDesaService;
import com.example.PortalDesa.service.TransaksiService;
import com.example.PortalDesa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by Sogumontar Hendra Simangunsong on 23/05/2020.
 */

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    UsersService usersService;

    @Autowired
    TransaksiService transaksiService;

    @Autowired
    ProdukDesaService produkDesaService;


    public String  sendEmail(String idPesanan, Integer indikator){
        DataTransaksi dataTransaksi = searchDataTransaksi(idPesanan);

        String msg=checkIndikator(dataTransaksi.getNama(),indikator);
        String keterangan ="Gagal";
        String msgFinal =msg;
        if(indikator==1){
            keterangan = "Berhasil";
            msgFinal = msg+ generatePesanan(dataTransaksi.getSkuProduk()) +
                    "\n Alamat Tujuan : " + dataTransaksi.getAlamat() +
                    "\nTotal Harga Pesanan : " + dataTransaksi.getHargaTotal()+
                    "\nMetode Pembayaran : " + dataTransaksi.getHargaTotal()
                    + "\n\n\n\nTerimakasih telah menggunakan aplikasi kami."+ "\nSampai jumpa di pesanan berikutnya ";
        }
        final String username = MailDefaults.EMAIL;
        final String password = MailDefaults.PASSWORD;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MailDefaults.EMAIL));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(dataTransaksi.getEmail())
            );
            message.setSubject("Transaksi Portal Desa " + keterangan);
            message.setText(msgFinal);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Success";
    }

    @Override
    public String generateMessage(String idPesanan) {
        return null;
    }

    @Override
    public String checkIndikator(String nama ,Integer indikator) {
        String message="Hello " + nama + "\nMaaf pesanan kamu tidak dapat di proses oleh admin PORTAL DESA" + "\nAnda dapat melakukan transaksi kembali"
                + "\n\n\n\nTerimakasih telah menggunakan aplikasi kami."+ "\nSampai jumpa di pesanan berikutnya " + nama;
        if(indikator==1) {
            message = "Hello " + nama + "\nPesanan kamu telah berhasil di konfirmasi oleh admin PORTAL DESA"
                    + "\nTerimakasih telah melakukan transaksi di aplikasi kami. \nPesanan kamu akan segera dikirimkan\n\n"+ "\nBerikut daftar pesanan kamu " + nama;
        }
        return message;
    }

    @Override
    public String generatePesanan(List<String> pesaanan) {
        String pesanan ="";
        for(String dat : pesaanan){
            pesanan+="\n Nama : " + getDetailProduk(dat).getNama() + " Harga : " + getDetailProduk(dat).getHarga();
        }
        return pesanan;
    }

    @Override
    public DataTransaksi searchDataTransaksi(String idPesanan) {
        TransaksiProduk transaksiProduk = transaksiService.findById(idPesanan);
        Users users= usersService.findBySku(transaksiProduk.getSkuCustomer());
        String str[]= transaksiProduk.getSkuProduk().split(",");
        List<String> data= new ArrayList<String>();
        data= Arrays.asList(str);
        DataTransaksi dataTransaksi= new DataTransaksi(
                transaksiProduk.getSkuCustomer(),
                data,
                users.getEmail(),
                users.getName(),
                transaksiProduk.getHarga(),
                transaksiProduk.getAlamat(),
                transaksiProduk.getMetode()
        );
        return dataTransaksi;
    }

    @Override
    public ProdukDesa getDetailProduk(String skuProduk) {
        return produkDesaService.findBySku(skuProduk);
    }
}
