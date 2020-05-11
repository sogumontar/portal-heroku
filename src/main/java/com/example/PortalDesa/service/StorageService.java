package com.example.PortalDesa.service;

import java.io.IOException;

/**
 * Created by Sogumontar Hendra Simangunsong on 11/05/2020.
 */
public interface StorageService {

    byte[] loadImage(String path,String fileName) throws IOException;
}
