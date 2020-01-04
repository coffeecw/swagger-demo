package com.cwcoffee.swagger.controller;

import com.cwcoffee.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cw
 * @Date 2020/01/04 11:38
 */
@RestController
@Api(tags = "hello控制器",description = "hello控制器")
public class HelloController {

    @ApiOperation("处理hello请求")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("处理user请求")
    @GetMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("处理user请求")
    @PostMapping("/get")
    public User getUser(@ApiParam("用户名") String username){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123456");
        return user;
    }
}
