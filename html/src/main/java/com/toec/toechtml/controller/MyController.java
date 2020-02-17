package com.toec.toechtml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MyController {

    @RequestMapping("/doFindVipCenter")
    public String doFindVipCenter(){
        RestTemplate restTemplate = new RestTemplate();
        String url =  "http://127.0.0.1:8007/doFindVipCenter";
        return restTemplate.getForObject(url,String.class);
    }
}
