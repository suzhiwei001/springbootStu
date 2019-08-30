package com.szw.springbootdemosu.mapper;

import com.szw.springbootdemosu.po.SaasPurchaseBillDetialPo;
import org.springframework.stereotype.Repository;

@Repository
public interface SassPurchaseDetialMapper {
    /**
     * 根据IP查询详情
     * @return SaasPurchaseBillDetialPo
     */
    SaasPurchaseBillDetialPo querySaasPurchaseBillDetialIp(int ip);
}
