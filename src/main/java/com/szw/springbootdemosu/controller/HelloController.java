package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.config.redis_config.RedisCacheUtil;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {
    @Autowired
    SaasPurchaseBillDetialService saasPurchaseBillDetialService;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @RequestMapping("/sayHello")
    public String hello(){
        return "hello world - "+saasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(2);
    }

    @RequestMapping("/redisTest")
    public String redisTest(String organSign,String sourcePref){
        List<String> inventoryRollBackKeys = new ArrayList<>();

        String value = redisCacheUtil.getCacheObject(organSign+sourcePref);
        if(!StringUtils.isEmpty(value)){
            System.out.println("key存在");
        }else{
            redisCacheUtil.setCacheObject(organSign+sourcePref, "redis-test", 15, TimeUnit.MINUTES);
            inventoryRollBackKeys.add(organSign+sourcePref);
        }
        if(!StringUtils.isEmpty(value)){
            redisCacheUtil.deleteKey(inventoryRollBackKeys.toArray(new String[inventoryRollBackKeys.size()]));
        }



        return "redis test";
    }
}
