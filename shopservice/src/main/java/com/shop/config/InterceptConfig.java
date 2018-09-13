package com.shop.config;

import com.shop.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
//@Configuration
//public class InterceptConfig  implements WebMvcConfigurer, InitializingBean {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor()).addPathPatterns("/api/test/notToken");
//    }
//
//
//    @Bean
//    AuthorizationInterceptor interceptor(){
//        return new AuthorizationInterceptor();
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
//        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
//    }
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");//设置允许跨域的路径
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//}
