package com.dabao.solver.controller;

import com.dabao.api.Demo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestService implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        TestService.applicationContext = applicationContext;
    }

    public static Demo getDemoByBiz(String beanName) {
        String[] beanNames = applicationContext.getBeanNamesForType(Demo.class);
        return (Demo) applicationContext.getBean(beanNames[0]);
    }
}
