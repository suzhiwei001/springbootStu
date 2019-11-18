package com.szw.springbootdemosu.dto;

/**
 * @author suzhiwei
 * @Date 2019/11/14
 * @Describe
 */
public class TestDto {
    String aaa;
    String bbb;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "aaa='" + aaa + '\'' +
                ", bbb='" + bbb + '\'' +
                '}';
    }
}
