package com.szw.springbootdemosu.entity;

import com.google.common.collect.Maps;

import java.io.Serializable;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: 统一的返回结果.
 */
public class ResultVO implements Serializable {
    /**
     * 接口返回code码
     */
    private Integer code;

    /**
     * 接口返回的msg
     */
    private String msg;

    /**
     * 接口response返回参数
     */
    private Object result;

    public ResultVO() {
        this.result = Maps.newHashMap();
    }


    public ResultVO(int code, String msg) {
        this.result = Maps.newHashMap();
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
