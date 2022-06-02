package com.dabao.solver.controller;

import com.dabao.api.ProjectApi;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectService implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static List<ProjectApi> projectApiContainer = new ArrayList<>();

    @PostConstruct
    private void init() {
        String[] beanNames = applicationContext.getBeanNamesForType(ProjectApi.class);
        for (String beanName : beanNames) {
            projectApiContainer.add((ProjectApi) applicationContext.getBean(beanName));
        }
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        ProjectService.applicationContext = applicationContext;
    }

    public static ProjectApi getProjectApiByBiz(String bizCode) {
        for (ProjectApi api : projectApiContainer) {
            if (api.support(bizCode)) {
                return api;
            }
        }
        throw new RuntimeException("bizName error");
    }
}
