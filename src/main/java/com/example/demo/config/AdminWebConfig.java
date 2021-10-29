package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.WebConnection;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "js/**");

    }
}
