package cn.coolwind.shiro.web.controller;

import cn.coolwind.shiro.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/change")
    @ResponseBody
    public String change() {
        userService.changeRoleResource();
        return "ok!";
    }
}
