package com.szw.springbootdemosu.service;

import com.szw.springbootdemosu.po.SaasPurchaseBillDetialPo;

public interface SaasPurchaseBillDetialService {
    /**
     * 根据IP查询详情
     * @return SaasPurchaseBillDetialPo
     */
    SaasPurchaseBillDetialPo querySaasPurchaseBillDetialIp(int ip);
}
