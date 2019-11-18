package com.szw.springbootdemosu.filter.base;

/**
 * @author: uzdz
 * @date: 2018/8/27 11:44
 * @description: 客户端往后台的请求参数对象.
 */
public class RequestParams {
    /**
     * data业务参数
     */
    private String data;

    /**
     * 登录后颁发的令牌token
     */
    private String token;

    /**
     * 输入参数签名结果
     */
    private String sign;

    /**
     * 客户端
     */
    private String client;

    /**
     * 版本号
     */
    private String version;

    /**
     * mac地址
     */
    private String mac;

    /**
     * ip地址
     */
    private String ip;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "data=" + data +
                ", token='" + token + '\'' +
                ", sign='" + sign + '\'' +
                ", client='" + client + '\'' +
                ", version='" + version + '\'' +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
