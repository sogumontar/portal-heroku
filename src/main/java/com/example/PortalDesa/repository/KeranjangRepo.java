package com.example.PortalDesa.repository;

import com.example.PortalDesa.model.Keranjang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/05/2020.
 */
@Repository
public interface KeranjangRepo extends JpaRepository<Keranjang,String> {
    @Query("SELECT k from Keranjang k where k.status=1")
    List findAll();

    @Query("SELECT k ,p from Keranjang k JOIN ProdukDesa p  ON k.idProduk LIKE p.sku ")
    List findAllForWeb();

    @Query("SELECT k from Keranjang k where k.status=1 AND  k.idCustomer LIKE ?1")
    List findAllBySkuCustomer(String skuCustomer);

    @Query("SELECT k, p from Keranjang k JOIN ProdukDesa p  ON k.idProduk LIKE p.sku where k.status=1 AND  k.idCustomer LIKE ?1")
    List findAllBySkuCustomerForWeb(String skuCustomer);

    @Query("SELECT k from Keranjang k where k.status=1 AND  k.skuDesa LIKE ?1")
    List findAllByMerchant(String skuDesa);

    @Query("SELECT k , p from Keranjang k  JOIN ProdukDesa p  ON k.idProduk LIKE p.sku where k.status=1 AND  k.skuDesa LIKE ?1")
    List findAllByMerchantForWeb(String skuDesa);

    @Query("SELECT COUNT(k.id) from Keranjang k where k.idProduk LIKE ?1 AND  k.idCustomer LIKE ?2 AND k.status=1")
    Integer check(String idProduk, String skuCustomer);

    Boolean existsByIdProdukAndIdCustomerAndStatus(String idProduk, String idCustomer, Integer status);

    Keranjang findByIdProdukAndIdCustomerAndStatus(String idProduk, String idCustomer, Integer status);
    @Transactional
    @Modifying
    @Query("UPDATE Keranjang k set k.status=3 where k.idCustomer LIKE ?1")
    void updateKeranjang(String sku);

    @Transactional
    @Modifying
    @Query("UPDATE Keranjang k set k.jumlah=?2 where k.id LIKE ?1")
    Integer update(String id, Integer jumlah);


    @Transactional
    @Modifying
    @Query("UPDATE Keranjang k set k.jumlah=?3 where k.idProduk LIKE ?1 AND k.idCustomer LIKE ?2")
    Integer updateJumlahCart(String idProduk, String skuCustomer, Integer jumlah);


    @Transactional
    @Modifying
    void deleteById(String id);




}
