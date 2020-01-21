package com.szw.springbootdemosu.ceshi;

import com.szw.springbootdemosu.SpringbootdemosuApplication;
import com.szw.springbootdemosu.po.SaasPurchaseBillDetialPo;
import com.szw.springbootdemosu.service.SaasPurchaseBillDetialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author suzhiwei
 * @Date 2020/01/20
 * @Describe
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootdemosuApplication.class)
public class RoolBacTest {

    @Autowired
    private SaasPurchaseBillDetialService SaasPurchaseBillDetialService;
    @Test
    public void test1(){
        SaasPurchaseBillDetialPo saasPurchaseBillDetialPo = SaasPurchaseBillDetialService.querySaasPurchaseBillDetialIp(1);
        System.out.println(saasPurchaseBillDetialPo.toString());
    }
}
