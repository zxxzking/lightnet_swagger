package com.lightnet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lightnet.mapper")
public class SwaggerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApiApplication.class, args);
    }

}
