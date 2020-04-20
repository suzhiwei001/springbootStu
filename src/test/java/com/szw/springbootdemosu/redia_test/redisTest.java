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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
        List<String> users = setUserList(1,null);
        ValueOperations<String, String> stringStringValueOperations = redisCacheUtil.setCacheObject(key, users.get(0), 15, TimeUnit.MINUTES);
    }

    /**
     * 通过key获取redis，String的value
     */
    @Test
    public void redisGetStr(){
        String userObj = redisCacheUtil.getCacheObject("key_user_test");
        User user = JSONObject.parseObject(userObj, User.class);
        System.out.println(user);
    }

    /**
     * 向list添加元素，方向 left
     */
    @Test
    public void redisSetLeftList(){
        String key = "key_user_test_list";
        List<String> users = setUserList(20,"left");
        redisCacheUtil.setCacheListAtLeft(key,users);
    }

    /**
     * 向list添加元素，方向right
     */
    @Test
    public void redisSetRightList(){
        String key = "key_user_test_list";
        List<String> users = setUserList(2,"right");
        redisCacheUtil.setCacheListAtRight(key,users);
    }

    /**
     * 获取list对象从左边取，会删除
     */
    @Test
    public void getCacheListAtLeft(){
        String key = "key_user_test_list";
        List<User> list = redisCacheUtil.getCacheListAtLeft(key);
        System.out.println(list.get(0));
    }

    /**
     * 获取单个对象，从左边获取，会删除
     */
    @Test
    public void getCacheAtLeft(){
        String key = "key_user_test_list";
        String userStr = redisCacheUtil.getCacheAtLeft(key);
        User user = JSONObject.parseObject(userStr, User.class);
        System.out.println(user);
    }

    /**
     * 给定范围获取list对象,不会删除
     */
    @Test
    public void getCacheListIndex(){
        String key = "key_user_test_list";
        long arg1 = 3;
        long arg2 = 5;
        List<User> users = redisCacheUtil.getCacheListIndex(key, arg1, arg2);
        System.out.println(users);
    }

    /**
     * 准备数据
     * @param n
     * @param education
     * @return
     */
    private List<String> setUserList(int n,String education){
        ArrayList<String> users = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            User user = new User();
            user.setName("admin");
            user.setAge(22);
            user.setSex("男");
            user.setAdress("北京");
            user.setEducation("博士");
            user.setSort((long)i);
            user.setEducation(education);
            users.add(JSON.toJSONString(user));
        }
        return users;
    }

    @Test
    public void dayatest(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //默认收集7天的销售日报数据
        int dateNum = 43;
        int num = dateNum;
        for (int i = 1; i <= dateNum; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
            Date today = calendar.getTime();
            String result = format.format(today);
            if(i==1){
                String endTime=result;
                System.out.println("endTime:"+endTime);

            }
            if(i == num){
                String startTime=result;
                System.out.println("startTime:"+startTime);
            }
        }
    }
}
