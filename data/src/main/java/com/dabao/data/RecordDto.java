package com.dabao.data;

import java.math.BigDecimal;
import java.util.Map;

public class RecordDto {
    private Long id;
    private String name;
    /**
     * 产品类型
     */
    private String bizCode;
    private String manager;
    private String department;
    private Double amount;
    private BigDecimal earnRate;
    private ProjectStatus status;

    Map<String, String> propertyMap;

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

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public DisplayInfo toDisplayInfo() {
        DisplayInfo info = new DisplayInfo();
        info.setId(id);
        info.setAmount(amount);
        info.setDepartment(department);
        info.setManager(manager);
        info.setStatus(status.getName());
        info.setEarnRate(earnRate);
        info.setPropertyMap(propertyMap);
        return info;
    }
}
