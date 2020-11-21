package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 用于解耦 该服务得全局得异常降级方法 兜底方法
 *负责 兜底
 * 可以维每一个方法设置 兜底处理
 */
@Component
public class PaymentFalbackService implements PaymentHystrixService
{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------paymentInfo_OK -----------fall back ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------paymentInfo_TimeOut -----------fall back ";
    }
}
