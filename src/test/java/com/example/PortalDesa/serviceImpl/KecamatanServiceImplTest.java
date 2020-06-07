package com.example.PortalDesa.serviceImpl;

import com.example.PortalDesa.model.Kecamatan;
import com.example.PortalDesa.repository.KecamatanRepo;
import com.example.PortalDesa.service.implement.KecamatanServiceImpl;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Created by Sogumontar Hendra Simangunsong on 12/05/2020.
 */
public class KecamatanServiceImplTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    Kecamatan kecamatan;
    @Mock
    KecamatanRepo kecamatanRepo;
    @InjectMocks
    KecamatanServiceImpl kecamatanService;

}
