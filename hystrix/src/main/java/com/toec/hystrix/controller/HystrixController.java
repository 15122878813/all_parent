package com.toec.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getRestTemplate")
    @HystrixCommand(fallbackMethod = "get")
    public String getRestTemplate(){
//        vip是注册中心注册的注册信息---spring-application-name
        String url = "http://vip/doFindVipCenter";
        String s = restTemplate.getForObject(url, String.class);
        return s;
    }
    //下面的方法不进行直接调用
    public String get(){
        return "后边的服务调用熔断/降级";
    }
}
