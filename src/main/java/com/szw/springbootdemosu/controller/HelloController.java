package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用于测试", description = "测试相关的 Rest API")
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;
    @PostMapping("/say")
    public String hello(){
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }
}
