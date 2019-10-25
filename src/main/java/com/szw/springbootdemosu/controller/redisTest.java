package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.dto.RedisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suzhiwei
 * @Date 2019/10/24
 * @Describe
 */
@RestController
@RequestMapping("/redis")
public class redisTest {
    @Autowired
    private com.szw.springbootdemosu.config.JedisPageUtil jedisPageUtil;
    private Map<String, String> map = new HashMap<>();
    @RequestMapping("/redisSyn")
    @ResponseBody
    public String redisSyn(@RequestBody RedisDto redisDto){
        Jedis jedis = null;
        try {
            jedis = jedisPageUtil.getResource();
            boolean flag = jedisPageUtil.tryGetDistributedLock(jedis, redisDto.getName(), redisDto.getId(), 50000);
            if(flag){
                System.out.println("设置分布式锁成功");
                return "true";
            }else{
                System.out.println("设置分布式锁失败");
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            boolean b = jedisPageUtil.releaseDistributedLock(jedis, redisDto.getName(), redisDto.getId());
            if(b){
                System.out.println("释放分布式锁成功");
            }
        }
        return "true";
    }
}
