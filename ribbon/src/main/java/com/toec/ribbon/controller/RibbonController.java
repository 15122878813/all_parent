package com.toec.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class RibbonController{

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getRestTemplate")
    public String getRestTemplate(){
//        vip是注册中心注册的注册信息---spring-application-name
        String url = "http://vip/doFindVipCenter";
        return restTemplate.getForObject(url,String.class);
    }
}
