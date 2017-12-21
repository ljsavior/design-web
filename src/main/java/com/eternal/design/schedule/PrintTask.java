package com.eternal.design.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yeyang.lj on 2017/10/19.
 */
//@Configuration
//@EnableScheduling
public class PrintTask {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ThreadLocal<DateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Scheduled(cron = "0/20 * * * * ?") //每20s执行一次
    public void print() {
        logger.info("当前时间为：{}", dateFormat.get().format(new Date()));
    }
}
