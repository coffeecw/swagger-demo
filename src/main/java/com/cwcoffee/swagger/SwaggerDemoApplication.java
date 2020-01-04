package com.cwcoffee.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
        System.out.println("swagger-ui入口:"+"http://localhost:8080//swagger-ui.html#/");
    }

}
