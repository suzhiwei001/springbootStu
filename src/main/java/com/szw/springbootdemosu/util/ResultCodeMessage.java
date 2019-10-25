package com.szw.springbootdemosu.util;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 */
public interface ResultCodeMessage {

    //系统公用code
    int SUB_SUCCESS_CODE = 0;
    String SUB_SUCCESS_MESSAGE = "接口请求成功";
    int PARAMS_FAIL_CODE = 1;
    String PARAMS_FAIL_MESSAGE = "接口参数错误";
    //用户订单业务错误码 11001-12000

}
