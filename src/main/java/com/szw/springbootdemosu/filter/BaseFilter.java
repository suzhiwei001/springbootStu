package com.szw.springbootdemosu.filter;

import com.szw.springbootdemosu.filter.util.RequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: uzdz
 * @date: 2018/8/30 14:23
 * @description: 顶层路由日志记录
 */
public class BaseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization,x-requested-with,client,sign,token,Accept,Origin,Referer,User-Agent,Cookie,Cookie3,AppVer");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        RequestWrapper requestWrapper = new RequestWrapper(request);
        filterChain.doFilter(requestWrapper,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
