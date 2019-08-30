package com.szw.springbootdemosu.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CronMapper {
    @Select("select cron from cron limit 1")
    public String getCron();
}
