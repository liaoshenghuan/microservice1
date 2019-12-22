package com.funtl.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.protocol.RequestContent;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 名称: LoginFilter
 * 描述：使用路由网关服务过滤
 *
 * @version v1.0
 * @author: lsh
 * @create: 2019-12-22 16:54
 **/
@Component
public class LoginFilter extends ZuulFilter {

    /**
     *pre 路由之前
     * routing   路由之时
     * post      路由之后
     * error   发送错误调用
     */
    @Override
    public String filterType() {

        return "pre";
    }

    /**
     *执行顺序，数值越小越靠前
     */
    @Override
    public int filterOrder() {

        return 0;
    }

    /**
     *是否过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();//当前的
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(token==null){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                HttpServletResponse response = currentContext.getResponse();
                response.setContentType("text/html;charset=utf-8");
                currentContext.getResponse().getWriter().write("非法请求");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
