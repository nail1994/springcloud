package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author dingwenbin
 * @create 2021-02-08
 * 自定义全局过滤器
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info(" --------进入自定义的全局网关过滤器------MyLogGatewayFilter---");

        //判断userName 如果为null 则弹出
        String userName = exchange.getRequest().getQueryParams().getFirst("userName");
        if (userName == null) {
            log.info("----用户名为null ----无法继续---");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
