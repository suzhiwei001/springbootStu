package com.szw.springbootdemosu.util;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author: suzhwei
 * @date: 2019-07-19 18:25
 * @description: 公共分页,实体类继承它就好，为pageHelper准备，这里暂时没人用
 */
public class PageCommon implements Serializable {

    @ApiModelProperty(
            value = "当前页数",
            name = "pageNum",
            example = "1"
    )
    private Integer pageNum = Integer.valueOf(1);
    @ApiModelProperty(
            value = "每页记录数",
            name = "pageSize",
            example = "10"
    )
    private Integer pageSize = Integer.valueOf(10);
    @ApiModelProperty(
            value = "排序字段",
            name = "orderBy",
            example = ""
    )
    private String orderBy;
    @ApiModelProperty(
            value = "是否进行count查询",
            name = "count",
            example = "true",
            hidden = true
    )
    private boolean count;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }
}
