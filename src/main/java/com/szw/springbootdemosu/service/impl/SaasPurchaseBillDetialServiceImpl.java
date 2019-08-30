package com.szw.springbootdemosu.service.impl;

import com.szw.springbootdemosu.mapper.SassPurchaseDetialMapper;
import com.szw.springbootdemosu.po.SaasPurchaseBillDetialPo;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaasPurchaseBillDetialServiceImpl implements SaasPurchaseBillDetialService {

    @Autowired
    private SassPurchaseDetialMapper sassPurchaseDetialMapper;
    @Override
    public SaasPurchaseBillDetialPo querySaasPurchaseBillDetialIp(int ip) {
        return sassPurchaseDetialMapper.querySaasPurchaseBillDetialIp(ip);
    }
}
