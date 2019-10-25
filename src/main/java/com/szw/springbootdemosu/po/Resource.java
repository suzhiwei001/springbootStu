package com.szw.springbootdemosu.po;

import java.io.Serializable;

/**
 * @author suzhiwei
 * @Date 2019/10/25
 * @Describe
 */
public class Resource implements Serializable {

    private String name;
    private String website;
    private String language;
    private String cid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
