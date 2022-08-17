package com.shouxin.yy.config;

import com.shouxin.yy.filters.ContextFilter;
import com.shouxin.yy.filters.MdcFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @time 2022/4/23 9:48 下午
 * @Author feikong
 */
@Configuration
public class FilterConfig {

    /**
     * 必要bean ，用于创建Filter
     * @return
     */
    @Bean
    public Filter contextFilter(){
        return new ContextFilter();
    }

    @Bean
    public Filter mdcFilter(){
        return new MdcFilter();
    }

    @Bean
    public FilterRegistrationBean contenxtFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(contextFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(8);
        registration.setName("contextFilter");
        return registration;
    }

    @Bean
    public FilterRegistrationBean mdcFilterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(mdcFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(9);
        registration.setName("mdcFilter");
        return registration;
    }
}
