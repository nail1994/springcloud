package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer
{
    //获取服务总数
    ServiceInstance instances(List<ServiceInstance> serviceInstances);


}
