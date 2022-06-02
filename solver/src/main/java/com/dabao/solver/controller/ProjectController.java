package com.dabao.solver.controller;

import com.dabao.api.ProjectApi;
import com.dabao.api.RequestParam;
import com.dabao.api.data.Result;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {

    @GetMapping("project/info/{biz}")
    public String getProjectInfo(@PathVariable String biz) {
        ProjectApi api = ProjectService.getProjectApiByBiz(biz);
        return api.bizName();
    }

    @PostMapping("project/create")
    public Result createProject(@RequestBody RequestParam requestParam) {
        ProjectApi api = ProjectService.getProjectApiByBiz(requestParam.getBizCode());
        return api.create(requestParam);
    }
}
