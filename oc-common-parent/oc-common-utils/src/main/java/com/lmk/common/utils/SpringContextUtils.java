package com.lmk.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringContextUtils() {
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext = ac;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBeanById(String id) {
        return applicationContext.getBean(id);
    }

    public static Object getBeanByClass(Class c) {
        return applicationContext.getBean(c);
    }

    public static Map getBeansByClass(Class c) {
        return applicationContext.getBeansOfType(c);
    }
}
