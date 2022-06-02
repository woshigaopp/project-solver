package com.dabao.api;

import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

public class RequestParam {
    private String bizCode;
    private String projectName;
    private String department;
    private String manager;
    private Double amount;
    private Float rate;
    private Map<String, String> customProperty;

    public static void main(String[] args) {
        RequestParam a = new RequestParam();
        a.setProjectName("项目1");
        a.setProjectName("部门1");
        a.setAmount(1000.0);
        a.setRate(11.1f);
        a.setManager("经理1");
        a.setBizCode("PROD_TYPE_1");
        Map<String, String> b = new HashMap<>();
        b.put("property1", "value1");
        a.setCustomProperty(b);
        System.out.println(JSONUtil.toJsonStr(a));
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Map<String, String> getCustomProperty() {
        return customProperty;
    }

    public void setCustomProperty(Map<String, String> customProperty) {
        this.customProperty = customProperty;
    }
}
