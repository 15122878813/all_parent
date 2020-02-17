package com.toec.orderseat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderseatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderseatApplication.class, args);
    }

}
