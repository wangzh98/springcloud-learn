package com.wzh.springcloud.controller;

import com.wzh.springcloud.pojo.Dept;
import com.wzh.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }


    // 注册进来的微服务，获取一些信息
    @RequestMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        //得到某一个具体的微服务信息，通过具体的微服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance: instances) {
            System.out.println(
                    instance.getHost() + "\t" + instance.getPort() + "\t" +
                            instance.getUri() + "\t" + instance.getServiceId()
            );
        }
        return this.client;
    }

}
