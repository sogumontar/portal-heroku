package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.*;
import com.example.PortalDesa.model.defaults.MailDefaults;
import com.example.PortalDesa.repository.TransaksiPenginapanRepo;
import com.example.PortalDesa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Array;
import java.util.*;

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
    TransaksiPenginapanService transaksiPenginapanService;
    @Autowired
    TransaksiPenginapanRepo transaksiPenginapanRepo;

    @Autowired
    ProdukDesaService produkDesaService;

    @Autowired
    PenginapanService penginapanService;


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
    public String sendEmailPesanan(String metode, String alamat,Integer harga, String email) {
//        Users users= usersService.findBySku(skuCustomer);
//        TransaksiProduk transaksiProduk = transaksiService.findById(idPesanan);
        String keterangan ="Pesanan Baru";
        String metodeP;
        if(metode.equals("ATM Mandiri")){
            metodeP = "\nNo Rek : 5412751234123456"+"\nAtas Nama : Benyamin Simanungkalit";
        }else {
            metodeP = "\nNo Rek : 7712654312317006"+"\nAtas Nama : Ojaks Sidabukke";
        }
        String msgFinal ;
            keterangan = "Pesanan Baru";
            msgFinal = "\n Alamat Pengiriman : " + alamat +
                    "\n Metode Pembayaran : " + metode +
                    metodeP+
                    "\nTotal Harga Pesanan : " + harga
                    + "\n\n\n\nTerimakasih telah menggunakan aplikasi kami."+ "\nSampai jumpa di pesanan berikutnya ";
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
                    InternetAddress.parse(email)
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
    public String sendEmailPenginapan(String idPesanan, Integer indikator) {
        DataTransaksiPnginapan dataTransaksi = searchDataTransaksiPenginapan(idPesanan);

        String msg=checkIndikator(dataTransaksi.getNama(),indikator);
        String keterangan ="Gagal";
        String msgFinal =msg;
        if(indikator==1){
            keterangan = "Berhasil";
            Penginapan penginapan2= getDetailPenginapan(dataTransaksi.getSkuProduk());
            msgFinal = msg+
                    "\n Penginapan Tujuan : " + penginapan2.getNama() +
                    "\n Lokasi  Penginapan : " + penginapan2.getLokasi() +
                    "\nTanggal Check-In : " + dataTransaksi.getCheckin() +
                    "\nLama Menginap : " + dataTransaksi.getLamaMenginap() +
                    "\nTotal Harga Pesanan : " + dataTransaksi.getHargaTotal()+
                    "\nKode Pemesanan Penginapan : " + generateKodePemesanan(idPesanan,UUID.randomUUID().toString())+
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
        String skus=transaksiProduk.getSkuCustomer();
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
    public DataTransaksiPnginapan searchDataTransaksiPenginapan(String idPesanan) {
        TransaksiPenginapan transaksiPenginapan = transaksiPenginapanService.findById(idPesanan);
        String skus=transaksiPenginapan.getSkuCustomer();
        Users users= usersService.findBySku(transaksiPenginapan.getSkuCustomer());
        DataTransaksiPnginapan dataTransaksi= new DataTransaksiPnginapan(
                transaksiPenginapan.getSkuCustomer(),
                transaksiPenginapan.getSkuProduk(),
                users.getEmail(),
                users.getName(),
                transaksiPenginapan.getCheckin(),
                transaksiPenginapan.getLamaMenginap(),
                transaksiPenginapan.getHarga(),
                transaksiPenginapan.getKodePemesanan(),
                transaksiPenginapan.getMetode()
        );
        return dataTransaksi;
    }

    @Override
    public ProdukDesa getDetailProduk(String skuProduk) {
        return produkDesaService.findBySku(skuProduk);
    }

    @Override
    public Penginapan getDetailPenginapan(String skuProduk) {
        return penginapanService.findBySku(skuProduk);
    }

    @Override
    public String generateKodePemesanan(String idPesanan,String random) {
        transaksiPenginapanRepo.setKodePemesanan(idPesanan,random);
        return random;
    }
}
