package com.funtl.hello.spring.cloud.zuul.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 名称: WebAdminFeignFallbackProvider
 * 描述：配置路由网关失败是回调
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-22 16:32
 **/
@Component
public class WebAdminFeignFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        return "hello-spring-cloud-web-admin-feign";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
            *  网关向API服务请求失败，但是消费者客户端向网关发起的请求时成功的
             *  不应该把api的404，500等问题返回抛给客户端，
             *  网关和api服务集群对于客户端来说是黑盒
            */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,Object> map = new HashMap<>();
                map.put("status",200);
                map.put("message","无法连接网络，请检查网络！");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                // 和getBody中的内容编码一致
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
