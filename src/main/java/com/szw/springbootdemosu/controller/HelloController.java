package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;
    @RequestMapping("/sayHello")
    public String hello(){
        System.out.println("123");
        System.out.println("124");
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }
}
