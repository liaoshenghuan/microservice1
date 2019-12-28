package com.funtl.hello.spring.cloud.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 名称: AdminApplication
 * 描述：SpringAdmin 服务监控--服务端
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-28 22:33
 **/
@SpringBootApplication
@EnableAdminServer//开启admin功能
@EnableEurekaClient
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
