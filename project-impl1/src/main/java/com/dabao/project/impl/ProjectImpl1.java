package com.dabao.project.impl;

import com.dabao.api.ProjectApi;
import com.dabao.api.RequestParam;
import com.dabao.api.data.Result;
import com.dabao.api.data.Status;
import com.dabao.data.ProjectStatus;
import com.dabao.data.RecordDao;
import com.dabao.data.RecordDto;

import java.math.BigDecimal;

public class ProjectImpl1 implements ProjectApi {

    private RecordDao recordDao = new RecordDao();

    @Override
    public boolean support(String bizCode) {
        return "PROD_TYPE_1".equals(bizCode);
    }

    public String bizName() {
        return "内贸直租";
    }

    @Override
    public Result create(RequestParam param) {
        RecordDto recordDto = new RecordDto();
        recordDto.setName(param.getProjectName());
        recordDto.setBizCode(param.getBizCode());
        recordDto.setAmount(param.getAmount());
        recordDto.setEarnRate(new BigDecimal(param.getRate()));
        recordDto.setDepartment(param.getDepartment());
        recordDto.setManager(param.getManager());
        recordDto.setPropertyMap(param.getCustomProperty());
        recordDto.setStatus(ProjectStatus.draft);
        recordDto.setId(1L);

        if (recordDao.insert(recordDto) > 0) {
            Result result = new Result();
            result.setElapsed(0);
            result.setMessage(bizName());
            result.setStatus(Status.OK);
            result.setData(recordDto.toDisplayInfo().toDisplayInfo());
            return result;
        }

        Result result = new Result();
        result.setElapsed(0);
        result.setMessage(bizName());
        result.setStatus(Status.ERROR);
        result.setData(null);
        return result;
    }

    @Override
    public Result push() {
        return null;
    }

    @Override
    public Result verify() {
        return null;
    }

    @Override
    public Result destroy() {
        return null;
    }
}
