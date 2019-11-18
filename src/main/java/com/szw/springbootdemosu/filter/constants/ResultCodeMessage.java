package com.szw.springbootdemosu.filter.constants;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: 网关系统返回码.
 */
public interface ResultCodeMessage {

    // ==================系统公用code

    int SUB_SUCCESS_CODE = 1;
    String SUB_SUCCESS_MESSAGE = "接口请求成功";
    int PARAMS_FAIL_CODE = 2;
    String PARAMS_FAIL_MESSAGE = "接口参数错误";
    int SYSTEM_ERROR_FAIL_CODE = 9999;
    String SYSTEM_ERROR_FAIL_MESSAGE = "系统异常,请稍后重试";

    // ==================网关系统错误码返回码 9000 -10000

    int COMMON_PARAM_FAIL_CODE = 9000;
    String COMMON_PARAM_FAIL_MESSAGE = "请传入正确的公共参数!";
    int DATA_NO_PARAM_CODE = 9001;
    String DATA_NO_PARAM_MESSAGE = "请传入data参数!";
    int SERVER_NO_PARAM_CODE = 9002;
    String SERVER_NO_PARAM_MESSAGE = "请传入server参数!";
    int TOKEN_NO_PARAM_CODE = 9003;
    String TOKEN_NO_PARAM_MESSAGE = "请传入token参数!";
    int SIGN_NO_PARAM_CODE = 9004;
    String SIGN_NO_PARAM_MESSAGE = "请传入sign参数!";
    int INTERFACE_MINUTE_COUNT = 9005;
    String INTERFACE_MINUTE_COUNT_MESSAGE = "频繁调用接口，请一分钟后再试!";
    int USERID_DECRYPT_FAIL_CODE = 9006;
    String USERID_DECRYPT_FAIL_MESSAGE = "请先登录!";
    int SIGN_FAIL_ERROR_CODE = 9007;
    String SIGN_FAIL_ERROR_MESSAGE = "签名sign错误!";
    int SERVER_NOT_FOUND_ERROR_CODE = 9008;
    String SERVER_NOT_FOUND_ERROR_MESSAGE = "调用服务server不存在!";
    int TOKEN_EXPIRE_COUNT_CODE = 9009;
    String TOKEN_EXPIRE_COUNT_MESSAGE = "token已经过期!";
    int TOKEN_ANALYSIS_ERROR_CODE = 9010;
    String TOKEN_ANALYSIS_ERROR_MESSAGE = "token令牌错误!";
    int TOKEN_HANDLE_ERROR_CODE = 9010;
    String TOKEN_HANDLE_ERROR_MESSAGE = "token分析异常!";
    int REQUEST_METHOD_ERROR_CODE = 9011;
    String REQUEST_METHOD_ERROR_MESSAGE = "请求方式错误!";
    int GATEWAY_ERROR_CODE = 9012;
    String GATEWAY_ERROR_MESSAGE = "网关转发异常!";
    int SERVER_ERROR_CODE = 9013;
    String SERVER_ERROR_MESSAGE = "服务端处理异常!";
    int SERVER_STOP_WORK_CODE = 9014;
    String SERVER_STOP_WORK_MESSAGE = "当前请求服务正在维护中...";
    int MUST_HTTPS_REQUEST_CODE = 9015;
    String MUST_HTTPS_REQUEST_MESSAGE = "请求协议必须为HTTPS!";
    int GATEWAY_SUCCESS_CODE = 9016;
    String GATEWAY_SUCCESS_MESSAGE = "SaaS3.0  API网关系统接口正常，请勿使用浏览器访问!";
    int USER_INFO_ERROR_CODE = 9017;
    String USER_INFO_ERROR_MESSAGE = "用户信息检查异常!";
    int CLIENT_NO_PARAM_CODE = 9018;
    String CLIENT_NO_PARAM_MESSAGE = "请传入client参数!";
    int CLIENT_NO_EXISTS_CODE = 9019;
    String CLIENT_NO_EXISTS_MESSAGE = "未授权的客户端!";
    int START_ENV_ERROR_CODE = 9020;
    String START_ENV_ERROR_MESSAGE = "启动环境错误，请联系开发人员!";
    int SERVER_CONVER_LIST_PUSH_ERROR_CODE = 9021;
    String SERVER_CONVER_LIST_PUSH_ERROR_MESSAGE = "服务列表转换异常，请联系开发人员!";
    int SERVER_LIST_PUSH_ERROR_CODE = 9021;
    String SERVER_LIST_PUSH_ERROR_MESSAGE = "服务列表拉取异常，请联系开发人员!";
    int USER_SECURITY_FAIL_CODE = 9022;
    String USER_SECURITY_FAIL_MESSAGE = "用户安全授权，认证失败!";

    // == 用户业务公共错误码 10001-11000==

    int USER_NOT_FOUNT_CODE = 10001;
    String USER_NOT_FOUNT_MESSAGE = "用户不存在";
}
