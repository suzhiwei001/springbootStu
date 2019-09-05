package com.szw.springbootdemosu.service.impl;

import com.szw.springbootdemosu.po.SaasPurchaseBillInfo;
import com.szw.springbootdemosu.service.SaasPurchaseBillInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suzhiwei
 * @Date 2019/9/5
 * @Describe
 */
@Service
public class SaasPurchaseBillInfoServiceImpl implements SaasPurchaseBillInfoService {
    @Autowired
    private SaasPurchaseBillInfoMapper saasPurchaseBillInfoMapper;
    @Override
    public SaasPurchaseBillInfo queryPurchaseBillInfo(Integer id) {
        //return saasPurchaseBillInfoMapper.selectByPrimaryKey(id);
        return null;
    }

    @Override
    public SaasPurchaseBillInfo selectByPrimaryKeyIp(int id) {
        return saasPurchaseBillInfoMapper.selectByPrimaryKeyIp(id);
    }

    @Override
    public List<SaasPurchaseBillInfo> queryPurchaseBillInfoAll() {

       // return saasPurchaseBillInfoMapper.selectAll();
        return null;
    }
}
