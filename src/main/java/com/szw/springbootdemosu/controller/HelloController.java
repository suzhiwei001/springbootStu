package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.config.Person;
import com.szw.springbootdemosu.mapper.SaasPurchaseBillInfoMapper;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    Person person;
    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;
    @Autowired
    SaasPurchaseBillInfoMapper saasPurchaseBillInfoMapper;
    @RequestMapping("/sayHello")
    public String hello(){
        System.out.println(person);
        saasPurchaseBillInfoMapper.selectAll();
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }
}
