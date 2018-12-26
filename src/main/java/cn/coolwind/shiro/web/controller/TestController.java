package cn.coolwind.shiro.web.controller;

import cn.coolwind.shiro.web.entity.Test;
import cn.coolwind.shiro.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public Object test() {
        Test test = testService.getById(1);
        return test;
    }

}
