package com.szw.springbootdemosu.service.impl;

import com.szw.springbootdemosu.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author suzhiwei
 * @Date 2019/9/3
 * @Describe
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Override
    public void executeAsync() {
        logger.info("start executeAsync");
        try {
            Thread.sleep(1000);
            System.out.println("打印任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}
