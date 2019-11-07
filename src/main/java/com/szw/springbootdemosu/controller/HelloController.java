package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.fruit.FruitName;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;

    @FruitName("hello world")
    @RequestMapping("/sayHello")
    public String hello(){
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }
}
