package com.szw.springbootdemosu.redia_test.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author suzhiwei
 * @Date 2020/01/21
 * @Describe
 */
@Data
public class User implements Serializable {

    private String name;
    private int age;
    private String sex;
    private String adress;
    private String education;
}
