package com.example.PortalDesa.serviceImpl;

import com.example.PortalDesa.model.TransaksiProduk;
import com.example.PortalDesa.repository.TransaksiProdukRepo;
import com.example.PortalDesa.service.implement.TransaksiServiceImpl;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/05/2020.
 */
public class TransaksiServiceImplTests {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    TransaksiProduk transaksiProduk;
    @Mock
    TransaksiProdukRepo transaksiProdukRepo;
    @InjectMocks
    TransaksiServiceImpl transaksiService;

    @Ignore
    @Test
    public void save(){
        TransaksiProduk transaksiProduk1 = new TransaksiProduk();
        transaksiService.save(transaksiProduk1,1);
        doNothing().when(transaksiService).save(transaksiProduk1,1);
        Mockito.verify(transaksiProdukRepo).save(transaksiProduk1);
    }
}
