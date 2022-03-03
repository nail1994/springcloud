package com.atguigu.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dingwenbin
 * @create 2022-02-10
 */
@RestController
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String serviceURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable Long id) {
        return restTemplate.getForObject(serviceURL + "/payment/nacos/" + id, String.class);
    }



}
