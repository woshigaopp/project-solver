package com.dabao.data;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Map;

public class DisplayInfo {
    private Long id;
    private String name;
    /**
     * 产品类型
     */
    private String bizName;
    private String manager;
    private String department;
    private Double amount;
    private BigDecimal earnRate;
    private String status;
    private Map<String,String> propertyMap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
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

    public BigDecimal getEarnRate() {
        return earnRate;
    }

    public void setEarnRate(BigDecimal earnRate) {
        this.earnRate = earnRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public String toDisplayInfo() {
        JSONObject json = new JSONObject();
        json.put("项目id", getId());
        json.put("项目名称", getName());
        json.put("产品类型", getBizName());
        json.put("项目经理", getManager());
        json.put("部门", getDepartment());
        json.put("项目金额", getAmount());
        json.put("收益率", getEarnRate());
        json.put("状态", getStatus());
        for (String key : propertyMap.keySet()) {
            json.put(key, propertyMap.get(key));
        }
        return json.toJSONString();
    }
}
