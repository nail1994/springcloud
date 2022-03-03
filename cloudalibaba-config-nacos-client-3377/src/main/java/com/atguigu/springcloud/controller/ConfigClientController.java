package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.util.TestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingwenbin
 * @create 2022-02-14
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
//        return TestUtil.getConfigInfo();
        return configInfo;
    }

}
