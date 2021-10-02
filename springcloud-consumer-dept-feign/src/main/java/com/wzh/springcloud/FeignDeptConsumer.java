package com.wzh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.wzh.springcloud"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.wzh.springcloud"})
//@ComponentScan("com.wzh.springcloud")
public class FeignDeptConsumer {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer.class, args);
    }
}
