package com.dabao.api;

import com.dabao.api.data.Result;
import dabao.beanloader.anotation.Spi;

@Spi
public interface ProjectApi {
    boolean support(String bizCode);
    String bizName();
    Result create(RequestParam requestParam);
    Result push();
    Result verify();
    Result destroy();
}
