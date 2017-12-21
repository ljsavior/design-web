package com.eternal.design.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by yeyang.lj on 2017/10/19.
 */
@Component
public class SpringApplicationContextUtil implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(SpringApplicationContextUtil.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringApplicationContextUtil.applicationContext == null) {
            SpringApplicationContextUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
