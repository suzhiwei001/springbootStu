package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.dto.TestDto;
import com.szw.springbootdemosu.fruit.FruitName;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @FruitName("测试接口")
    @RequestMapping("/test")
    public TestDto test(HttpServletRequest request, @RequestBody TestDto testDto){
        String token = request.getHeader("token");
        System.out.println("入参:"+testDto.toString());
        return testDto;
    }
}
