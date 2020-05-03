package com.example.PortalDesa.service;

import com.example.PortalDesa.payload.request.DesaRequest;
import org.springframework.http.ResponseEntity;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/04/2020.
 */
public interface DesaService {
    public ResponseEntity<?> addDesa(DesaRequest desaRequest);
    public void updateDesa(String sku, DesaRequest desaRequest);
}
