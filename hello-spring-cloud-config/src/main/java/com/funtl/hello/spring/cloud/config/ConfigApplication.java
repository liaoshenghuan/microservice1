package com.funtl.hello.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 名称: ConfigApplication
 * 描述：yml配置文件管理服务提供
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-24 23:04
 **/
@SpringBootApplication
@EnableEurekaClient //配置表示服务提供者
@EnableConfigServer
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
