package com.example.PortalDesa.serviceImpl;

import com.example.PortalDesa.model.Penginapan;
import com.example.PortalDesa.repository.PenginapanRepo;
import com.example.PortalDesa.repository.SequenceProdukRepo;
import com.example.PortalDesa.service.implement.PenginapanServiceImpl;
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
 * Created by Sogumontar Hendra Simangunsong on 12/05/2020.
 */
public class PenginapanServiceImplTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    Penginapan penginapan;
    @Mock
    PenginapanRepo penginapanRepo;
    @Mock
    SequenceProdukRepo sequenceProdukRepo;
    @InjectMocks
    PenginapanServiceImpl penginapanService;


    @Test
    public void findAllTest() {
        List list = new ArrayList();
        Mockito.when(penginapanRepo.findAll()).thenReturn(list);
        assertEquals(list,penginapanService.findAll());
        Mockito.verify(penginapanRepo).findAll();
    }

    @Test
    public void  skuGenereatorTest(){
        Mockito.when(sequenceProdukRepo.existsByKey("hendra")).thenReturn(Boolean.TRUE);
        Mockito.when(penginapanService.skuGenereator("hendra","test")).thenReturn("HEND-TEST-001");
        assertEquals("TEST-HEND-001",penginapanService.skuGenereator("hendra","test"));
//        Mockito.verify(sequenceProdukRepo).existsByKey("HEND-TEST");
    }

    @Test
    public void  substrTest(){
        assertEquals("HEND",penginapanService.substr("hendra"));
    }

    @Test
    public void findBySku() {
        Penginapan penginapan1= new Penginapan();
        Mockito.when(penginapanRepo.findFirstBySku("SKU")).thenReturn(penginapan1);
        assertEquals(penginapan1,penginapanService.findBySku("SKU"));
        Mockito.verify(penginapanRepo).findFirstBySku("SKU");
    }



}
