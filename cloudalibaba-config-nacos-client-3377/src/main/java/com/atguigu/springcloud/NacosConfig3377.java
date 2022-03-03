package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dingwenbin
 * @create 2022-02-14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3377.class,args);
    }
}
