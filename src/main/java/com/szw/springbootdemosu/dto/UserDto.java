package com.szw.springbootdemosu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 * @Describe
 */
@ApiModel("用户入参实体")
public class UserDto {

    @ApiModelProperty("用户 name")
    private String name;
    @ApiModelProperty("用户 address")
    private String address;
    @ApiModelProperty("用户 age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
