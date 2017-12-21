package com.eternal.design.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by yeyang.lj on 2017/10/20.
 * 若为多个，则通过Order注解定义顺序。 @Order(value = 1)
 */
//@Component
public class MyStartupRunner implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... strings) throws Exception {
        logger.info("start up...");
    }
}
