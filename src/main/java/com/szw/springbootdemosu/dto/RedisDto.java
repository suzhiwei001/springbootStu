package com.szw.springbootdemosu.dto;

/**
 * @author suzhiwei
 * @Date 2019/10/24
 * @Describe
 */
public class RedisDto {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RedisDto{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
