package com.szw.springbootdemosu.service;

import com.szw.springbootdemosu.po.SaasPurchaseBillInfo;

import java.util.List;

/**
 * @author suzhiwei
 * @Date 2019/9/5
 * @Describe
 */
public interface SaasPurchaseBillInfoService {
    SaasPurchaseBillInfo queryPurchaseBillInfo(Integer id);
    SaasPurchaseBillInfo selectByPrimaryKeyIp(int id);
    List<SaasPurchaseBillInfo> queryPurchaseBillInfoAll();
}
