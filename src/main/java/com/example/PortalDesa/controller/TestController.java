package com.example.PortalDesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Sogumontar Hendra Simangunsong on 30/04/2020.
 */

@CrossOrigin
@Controller
public class TestController {
    @GetMapping("/")
    public String test (){
        return "hello dunia";
    }
}
