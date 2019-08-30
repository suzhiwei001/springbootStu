package com.szw.springbootdemosu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//代表springboot的启动类 用来标注主程序类 说明是一个springboot应用
@MapperScan("com.szw.springbootdemosu.mapper")
public class SpringbootdemosuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemosuApplication.class, args);
    }
}
