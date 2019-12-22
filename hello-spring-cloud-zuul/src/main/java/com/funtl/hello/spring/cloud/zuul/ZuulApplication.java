package com.funtl.hello.spring.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 名称: ZuulApplication
 * 描述：路由统一网关访问，配置云运用
 *      zuul--集群
 *     （使用统一网关来做服务聚合）
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-17 16:21
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
