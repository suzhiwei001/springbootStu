package com.szw.springbootdemosu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * https://www.cnblogs.com/mmzs/p/10161936.html -》1
 * 静态定时任务
 * 优点：使用@Scheduled 注解很方便
 * 缺点：当我们调整了执行周期的时候，需要重启应用才能生效，
 * 解决方式：使用接口定时任务可以达到实时生效的效果
 */
@Component
@Configuration  //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class SaticScheduleTask {
    private static final Logger logger = LoggerFactory.getLogger(SaticScheduleTask.class);
    @Scheduled(fixedRate=5000)//直接指定时间间隔，例如：5秒
    private void configureTasks(){
        logger.info("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
