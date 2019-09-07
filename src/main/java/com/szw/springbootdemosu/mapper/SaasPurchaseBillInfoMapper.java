package com.szw.springbootdemosu.mapper;

import com.szw.springbootdemosu.po.SaasPurchaseBillInfo;
import java.util.List;

public interface SaasPurchaseBillInfoMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(SaasPurchaseBillInfo record);

    /**
     *
     * @mbggenerated
     */
    SaasPurchaseBillInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    List<SaasPurchaseBillInfo> selectAll();

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SaasPurchaseBillInfo record);
}