package com.liusl.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * created by l1 on 2017/7/5.
 */
@RestController
@EnableDiscoveryClient
public class HelloController {
    private final Logger logger= Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String index(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello,host:"+serviceInstance.getHost()+",service_id:"+serviceInstance.getServiceId());
        return  "Hello World!";
    }
}
