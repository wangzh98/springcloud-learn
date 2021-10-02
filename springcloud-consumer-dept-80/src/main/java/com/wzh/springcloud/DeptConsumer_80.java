package com.wzh.springcloud;

import com.wzh.myrule.DemoRandomRule;
import com.wzh.myrule.DemoRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候就能去加载自定义的ribbon类
@RibbonClient(value = "SPRINGCLOUD-PROVIDER-DEPT", configuration = DemoRandomRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
