package com.szw.springbootdemosu.config;

import com.szw.springbootdemosu.mapper.CronMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * https://www.cnblogs.com/mmzs/p/10161936.html -》二
 * 动态定时任务
 * 实现接口SchedulingConfigurer
 * 数据库表设置时长
 * 读取数据库时长执行任务
 */
@Component
@Configuration//1.主要用于标记配置类，兼备Component的效果
@EnableScheduling// 2.开启定时任务
public class DynamicScheduleTask implements SchedulingConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(DynamicScheduleTask.class);
    @Autowired
    CronMapper cronMapper;
    /**
     * 执行定时任务
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                ()->logger.info("执行动态定时任务:" + LocalDateTime.now().toLocalTime()),
                triggerContext ->{
                    String cron = cronMapper.getCron();
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                        logger.info("执行动态定时任务cron数据库值:" + cron);
                        //给默认值
                        cron = "0/5 * * * * ?";
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
