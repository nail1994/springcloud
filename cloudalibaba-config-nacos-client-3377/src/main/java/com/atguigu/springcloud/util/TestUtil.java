package com.atguigu.springcloud.util;

import org.springframework.beans.factory.annotation.Value;

import javax.security.auth.login.Configuration;

/**
 * @author dingwenbin
 * @create 2022-02-15
 */
public class TestUtil {
    @Value("${config.info}")
    private static String configInfo;

    public static String getConfigInfo(){
        return configInfo;
    }
}
