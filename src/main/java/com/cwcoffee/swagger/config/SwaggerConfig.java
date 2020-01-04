package com.cwcoffee.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author cw
 * @Date 2020/01/04 11:42
 */
@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    /**
     * 配置swagger的Docket的bean实例
     * @return
     */
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否启动swagger,如果为false，则swagger不能在浏览器中访问
                .enable(flag)
                .groupName("cw")
                .select()
                //RequestHandlerSelectors，配置扫描接口的方式
                //basePackage:指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation():扫描类上的注解,参数是一个注解的反射对象
                //withMethodAnnotation():扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.cwcoffee.swagger.controller"))
                //paths() 过滤什么路径
//                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger的信息 ApiInfo
     * @return
     */
    public ApiInfo apiInfo(){
        Contact contact = new Contact("cw", "", "");
        return new ApiInfo(
                "swagger-demo",
                "swagger-demo",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
