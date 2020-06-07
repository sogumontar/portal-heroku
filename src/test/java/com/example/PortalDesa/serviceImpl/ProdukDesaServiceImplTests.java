package com.example.PortalDesa.serviceImpl;

import com.example.PortalDesa.model.ProdukDesa;
import com.example.PortalDesa.repository.ProdukDesaRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.implement.ProdukDesaServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/05/2020.
 */
public class ProdukDesaServiceImplTests {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    ProdukDesa produkDesa;
    @Mock
    ProdukDesaRepo produkDesaRepo;
    @Mock
    SequenceProdukRepo sequenceProdukRepo;
    @InjectMocks
    ProdukDesaServiceImpl produkDesaService;

    @Test
    public void skuGeneratorTest(){
        Mockito.when(sequenceProdukRepo.existsByKey("hendra")).thenReturn(Boolean.TRUE);
        Mockito.when(produkDesaService.skuGenerator("hendra","test")).thenReturn("HEND-TEST-001");
        assertEquals("HEND-TEST-001",produkDesaService.skuGenerator("hendra","test"));
//        Mockito.verify(sequenceProdukRepo).existsByKey("HEND-TEST");
    }

    @Test
    public void subStrTest(){
        assertEquals("HEND",produkDesaService.subStr("hendra"));
    }

    @Test
    public void findAllBySkuDesaTest(){
        List list = new ArrayList();
        Mockito.when(produkDesaRepo.findAllBySkuAdmin("sku")).thenReturn(list);
        assertEquals(list,produkDesaService.findAllBySkuDesa("sku"));
        Mockito.verify(produkDesaRepo).findAllBySkuAdmin("sku");
    }

    @Test
    public void findAllTest() {
        List list = new ArrayList();
        Mockito.when(produkDesaRepo.findAll()).thenReturn(list);
        assertEquals(list,produkDesaService.findAll());
        Mockito.verify(produkDesaRepo).findAll();
    }

    @Test
    public void findBySku() {
        ProdukDesa produkDesa1= new ProdukDesa();
        Mockito.when(produkDesaRepo.findFirstBySku("SKU")).thenReturn(produkDesa1);
        assertEquals(produkDesa1,produkDesaService.findBySku("SKU"));
        Mockito.verify(produkDesaRepo).findFirstBySku("SKU");
    }

    @Test
    public void findAllSuspendTest() {
        List list = new ArrayList();
        Mockito.when(produkDesaRepo.findAllByStatus(2)).thenReturn(list);
        assertEquals(list,produkDesaService.findAllSuspend());
        Mockito.verify(produkDesaRepo).findAllByStatus(2);
    }


}
