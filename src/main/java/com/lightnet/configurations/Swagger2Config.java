package com.lightnet.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class Swagger2Config {

    @Bean
    public Docket createRestApi_Access() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API Access")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lightnet.api.controller.access"))
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    public Docket createRestApi_Reporting() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Reporting")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lightnet.api.controller.reporting"))
                .paths(PathSelectors.any())
                .build();

    }

    @Bean
    public Docket createRestApi_Payments() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Payments")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lightnet.api.controller.payments"))
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