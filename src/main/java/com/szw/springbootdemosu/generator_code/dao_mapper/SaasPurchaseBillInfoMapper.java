package com.szw.springbootdemosu.generator_code.dao_mapper;

import com.szw.springbootdemosu.generator_code.entity.SaasPurchaseBillInfo;
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