package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService
{

    /**
     * 正常访问 肯定ok
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:" + Thread.currentThread().getName() + " payment_OK,   id:"+id;
    }

    /**
     * 设置 兜底方法，设置时间->3秒
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id)
    {
        //int age = 10/0;

       int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "线程池:" + Thread.currentThread().getName() + " TimeOUT, 耗时3秒钟 , id:"+id;
    }


    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "线程池:" + Thread.currentThread().getName() + "8001兜底方法！ id:"+id;
    }

    /* 服务熔断 */
    @HystrixCommand(fallbackMethod = "paymentCrcuitBreaker_fallback",
    commandProperties = {
        @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
        @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
        @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
        @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") //失败率到达多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0 ){
            throw  new RuntimeException(" id 不能为负数..");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号:"+serialNumber;
    }

    public String paymentCrcuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数,请稍后再试 > <";
    }


}
