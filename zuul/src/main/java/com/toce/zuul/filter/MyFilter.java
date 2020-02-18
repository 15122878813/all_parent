package com.toce.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.scenario.effect.FilterContext;
import org.apache.http.protocol.RequestContent;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
//        return FilterConstants.ROUTE_TYPE; //在服务链中进行请求
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        String serviceId = (String)currentContext.get(FilterConstants.SERVICE_ID_KEY);
        if("vip".equals(serviceId)){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String userName = request.getParameter("userName");
        if(userName == null){
            currentContext.setSendZuulResponse(false); //阻止向后台服务转发调用
            currentContext.setResponseStatusCode(200);
            currentContext.setResponseBody("你没有userName,过滤过程中返回");
        }
        return null;
    }
}
