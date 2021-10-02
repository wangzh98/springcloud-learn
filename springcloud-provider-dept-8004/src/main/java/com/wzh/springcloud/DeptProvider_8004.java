package com.wzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider_8004 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8004.class, args);
    }
}