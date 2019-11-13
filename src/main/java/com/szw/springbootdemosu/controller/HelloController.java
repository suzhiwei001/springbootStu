package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.fruit.FruitName;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;

    @FruitName("hello world")
    @RequestMapping("/sayHello")
    public String hello(){
        logger.info("hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2).toString());
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }
}
