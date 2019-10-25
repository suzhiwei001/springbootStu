package com.szw.springbootdemosu.util;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 * @Describe 统一的返回结果
 */
public class ResultVO<T>{
    //0成功
    private int code;
    private String msg;
    private T result;
    public ResultVO(T result){
        this(ResultCodeMessage.SUB_SUCCESS_CODE,ResultCodeMessage.SUB_SUCCESS_MESSAGE,result);
    }

    public ResultVO(int code, String msg, T result){
        this.result=result;
        this.code=code;
        this.msg=msg;
    }

    public static<T> ResultVO<T> createSuccess(T result){
        return new ResultVO(result);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
