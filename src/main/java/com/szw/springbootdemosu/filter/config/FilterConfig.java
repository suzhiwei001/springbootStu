package com.szw.springbootdemosu.filter.config;

import com.szw.springbootdemosu.filter.BaseFilter;
import com.szw.springbootdemosu.filter.BaseFilterTwo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: suzhiwei
 * @date: 2019-09-16 14:22
 * @description: 多过滤器统一配置类
 */
@Configuration
public class FilterConfig {

    @Bean
    public BaseFilter baseFilter(){
        return new BaseFilter();
    }
    @Bean
    public BaseFilterTwo baseFilterTwo() {
        return new BaseFilterTwo();
    }

    @Bean
    public FilterRegistrationBean baseFilterRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(baseFilter());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("baseFilter");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        return registration;
    }

    @Bean
    public FilterRegistrationBean baseFilterTwoRegister() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //注入过滤器
        registration.setFilter(baseFilterTwo());
        //拦截规则
        registration.addUrlPatterns("/*");
        //过滤器名称
        registration.setName("baseFilterTwo");
        //过滤器顺序
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE-2);
        return registration;
    }

}
