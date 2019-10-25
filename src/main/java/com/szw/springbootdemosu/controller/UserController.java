package com.szw.springbootdemosu.controller;

import com.szw.springbootdemosu.dto.UserDto;
import com.szw.springbootdemosu.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 * @Describe 用户
 */
@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "新增用户接口", notes = "新增用户接口")
    @PostMapping("/add")
    public boolean addUser(){
        return true;
    }

    @ApiOperation("查询用户接口")
    @PostMapping("/find")
    public boolean findUser(@RequestBody UserDto userDto){
        return true;
    }

    @ApiOperation("修改用户接口")
    @PostMapping("/update")
    public UserVo updateUser(){
        UserVo user = new UserVo();
        user.setName("ceshi");
        user.setAge(12);
        user.setAddress("北京");
        return user;
    }

    @ApiIgnore//此接口不在swagger显示
    @ApiOperation("删除用户接口")
    @PostMapping("/delete")
    public boolean deleteUser(){
        return true;
    }
}
