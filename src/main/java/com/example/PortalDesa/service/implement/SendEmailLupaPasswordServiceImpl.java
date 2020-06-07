package com.example.PortalDesa.service.implement;

import com.example.PortalDesa.model.defaults.MailDefaults;
import com.example.PortalDesa.service.SendEmailLupaPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/06/2020.
 */

@Service
public class SendEmailLupaPasswordServiceImpl implements SendEmailLupaPasswordService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendEmail(String email, String kode) {
        String keterangan ="Gagal";
        String msgFinal;
            keterangan = "Berhasil";
            msgFinal = "\n Kode Lupa Password : " + kode +
                    "\nKode ini hanya berlaku hari ini saja (sampai pukul 23.59)  " + LocalDate.now().toString() ;
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
            message.setSubject("Transaksi Portal Desa Lupa Password" );
            message.setText(msgFinal);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Success";
    }

    @Override
    public String sendEmailNewPassword(String email, String newPassword) {
        String keterangan ="Gagal";
        String msgFinal;
        keterangan = "Berhasil";
        msgFinal = "\n Password baru anda : " + newPassword ;
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
            message.setSubject("Transaksi Portal Desa Password Baru" );
            message.setText(msgFinal);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Success";
    }

}
