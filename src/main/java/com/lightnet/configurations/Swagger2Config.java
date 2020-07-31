package com.lightnet.configurations;

import com.google.common.collect.Lists;
import com.lightnet.annotation.NoAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class Swagger2Config {

    @Bean
    public Docket createRestApi1() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API Access")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lightnet.api.controller.access"))
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    public Docket createRestApi2() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Balance")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lightnet.api.controller.balance"))
                .paths(PathSelectors.any())
                .build();

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API DOC")
                .description("lightnet api doc ")
                .version("0.0.1")
                .build();
    }
}