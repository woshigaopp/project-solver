package com.dabao.solver.controller;

import com.dabao.api.Demo;
import dabao.beanloader.anotation.SpiAutowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @SpiAutowired("demoImpl")
    private Demo demo;

    @GetMapping("hello")
    public String hello() {
        return TestService.getDemoByBiz("demoImpl").say();
    }
}
