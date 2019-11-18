package com.szw.springbootdemosu.filter.sign;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: uzdz
 * @date: 2018/10/27 16:30
 * @description: 签名枚举类
 */
public enum ClientEnum {
    C_NET_CLIENT("C#", "JKKLJOoasdlfC", 604800, true),
    WEB_CLIENT("web", "JCCLJOoasBdsfK", 604800, true),
    SAAS2_CLIENT("saas2", "ECCKJOo2sBdsfK", 604800, false),
    IOS_CLIENT("ios", "IOSKKK123KJOo2sBdsfK", 604800, true),
    ANDROID_CLIENT("android", "ANDROID3KJOo2sBdsTK", 604800, true),
    YKQ_CLIENT("ykq", "QKBLZOoSsdFfq", 604800, false),
    CRM_CLIENT("crm", "crmLZOoSsdFfq", 604800, false);

    private String client;

    private String secretKey;

    private Integer tokenExpireSecond;

    private boolean filterToke;

    ClientEnum(String client, String secretKey, Integer tokenExpireSecond, boolean filterToke) {
        this.client = client;
        this.secretKey = secretKey;
        this.tokenExpireSecond = tokenExpireSecond;
        this.filterToke = filterToke;
    }

    public static List<ClientEnum> get() {
        ClientEnum[] values = ClientEnum.values();
        List<ClientEnum> clientEnums = Arrays.asList(values);
        return clientEnums;
    }

    public static List<String> getAllClient() {
        ClientEnum[] values = ClientEnum.values();
        List<ClientEnum> clientEnums = Arrays.asList(values);
        return clientEnums.stream().map(ClientEnum::getClient).collect(Collectors.toList());
    }

    public static String getClientSecretKey(String client) {
        for (ClientEnum clientEnum : ClientEnum.values()) {
            if (clientEnum.getClient().equals(client)) {
                return clientEnum.getSecretKey();
            }
        }
        return null;
    }

    public static Integer getClientTokenExpireSecond(String client) {
        for (ClientEnum clientEnum : ClientEnum.values()) {
            if (clientEnum.getClient().equals(client)) {
                return clientEnum.getTokenExpireSecond();
            }
        }
        return null;
    }

    public static boolean getExistsFilterToken(String client) {
        for (ClientEnum clientEnum : ClientEnum.values()) {
            if (clientEnum.getClient().equals(client)) {
                return clientEnum.getFilterToke();
            }
        }
        return false;
    }

    public Integer getTokenExpireSecond() {
        return tokenExpireSecond;
    }

    public void setTokenExpireSecond(Integer tokenExpireSecond) {
        this.tokenExpireSecond = tokenExpireSecond;
    }

    public boolean isFilterToke() {
        return filterToke;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public boolean getFilterToke() {
        return filterToke;
    }

    public void setFilterToke(boolean filterToke) {
        this.filterToke = filterToke;
    }
}
