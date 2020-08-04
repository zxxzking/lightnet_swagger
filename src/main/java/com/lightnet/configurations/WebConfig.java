package com.lightnet.configurations;

import com.lightnet.handler.AuthHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthHandler()).addPathPatterns("/api/v1/balances/**");
        super.addInterceptors(registry);
    }


}
