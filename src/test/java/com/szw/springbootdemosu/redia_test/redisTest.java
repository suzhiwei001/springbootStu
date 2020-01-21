package com.szw.springbootdemosu.redia_test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szw.springbootdemosu.SpringbootdemosuApplication;
import com.szw.springbootdemosu.config.redis_config.RedisCacheUtil;
import com.szw.springbootdemosu.redia_test.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * redis 测试
 * @author suzhiwei
 * @Date 2020/01/21
 * @Describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemosuApplication.class)
@ActiveProfiles("dev")
public class redisTest {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    /**
     * 缓存String  超时设置
     */
    @Test
    public void redisSetStr(){
        String key = "key_user_test";
        User user = new User();
        user.setName("admin");
        user.setAge(22);
        user.setSex("男");
        user.setAdress("北京");
        user.setEducation("博士");
        String userStr = JSON.toJSONString(user);
        ValueOperations<String, String> stringStringValueOperations = redisCacheUtil.setCacheObject(key, userStr, 15, TimeUnit.MINUTES);
    }

    @Test
    public void redisGetStr(){
        String userObj = redisCacheUtil.getCacheObject("key_user_test");
        User user = JSONObject.parseObject(userObj, User.class);
        System.out.println(user);
    }
}
