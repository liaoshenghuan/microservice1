package com.funtl.hello.spring.cloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * 名称: ZipkinApplication
 * 描述：服务链路追踪
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-28 21:10
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
//@ComponentScan(nameGenerator = UniqueNameGenerator.class)
public class ZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class,args);
    }
}
