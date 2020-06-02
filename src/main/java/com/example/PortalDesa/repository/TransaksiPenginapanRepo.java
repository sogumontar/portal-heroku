package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.TransaksiPenginapan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 25/05/2020.
 */
@Repository
public interface TransaksiPenginapanRepo extends JpaRepository<TransaksiPenginapan, String> {
    //Web
    @Query("SELECT p, t FROM TransaksiPenginapan p JOIN Penginapan t ON p.skuProduk LIKE t.sku WHERE  p.status =1 AND p.skuCustomer LIKE ?1")
    public List findAllTransksiBySkuCustomerWeb(String sku);

    @Query("SELECT p, t FROM TransaksiPenginapan p JOIN Penginapan t ON p.skuProduk LIKE t.sku WHERE p.status <> 1 AND p.skuCustomer LIKE ?1")
    public List findAllPesananBayarBySkuCustomerWeb(String sku);

    @Query("SELECT p, t   FROM TransaksiPenginapan p JOIN Penginapan t ON p.skuProduk LIKE t.sku WHERE p.status =3 AND p.skuCustomer LIKE ?1")
    public List findAllPesananSelesaiBySkuCustomerWeb(String sku);

    @Query("SELECT p, t FROM TransaksiPenginapan p  JOIN Penginapan t ON p.skuProduk LIKE t.sku WHERE p.status=?1 ")
    public List findAllByStatusWeb(Integer status);

    @Query("SELECT p, t FROM TransaksiPenginapan p  JOIN Penginapan t ON p.skuProduk LIKE t.sku WHERE p.status <> 1 ")
    public List findAllPesananBayarWeb();


    @Query("SELECT p FROM TransaksiPenginapan p  WHERE  p.status =1 AND p.skuCustomer LIKE ?1")
    public List findAllTransksiBySkuCustomer(String sku);

    @Query("SELECT p FROM TransaksiPenginapan p WHERE p.status <> 1 AND p.skuCustomer LIKE ?1")
    public List findAllPesananBayarBySkuCustomer(String sku);

    @Query("SELECT p   FROM TransaksiPenginapan p  WHERE p.status =3 AND p.skuCustomer LIKE ?1")
    public List findAllPesananSelesaiBySkuCustomer(String sku);

    public List findAllByStatus(Integer status);

    @Query("SELECT p FROM TransaksiPenginapan p WHERE p.status <> 1 ")
    public List findAllPesananBayar();

    public TransaksiPenginapan findFirstById(String id);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiPenginapan p  SET p.resi=?2 , p.status=2 WHERE p.id LIKE ?1")
    public void update(String idPesanan, String gambar);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiPenginapan p  SET  p.status=0 WHERE p.id LIKE ?1")
    public void cancel(String idPesanan);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiPenginapan p  SET  p.status=1 WHERE p.id LIKE ?1")
    public void balikin(String idPesanan);

    @Query("SELECT COUNT(u.resi) FROM TransaksiPenginapan u WHERE u.skuCustomer LIKE ?1 ")
    Integer counter(String skuCustomer);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiPenginapan p  SET p.status=?2 WHERE p.id LIKE ?1")
    public void actionPesanan(String idPesanan, Integer status);

    @Modifying
    @Transactional
    @Query("UPDATE TransaksiPenginapan p  SET p.kodePemesanan=?2 WHERE p.id LIKE ?1")
    public void setKodePemesanan(String idPesanan, String kode);
}
