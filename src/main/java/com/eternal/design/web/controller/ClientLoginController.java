package com.eternal.design.web.controller;

import com.eternal.design.entity.User;
import com.eternal.design.service.UserService;
import com.eternal.design.web.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientLoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/client/login.json")
    @ResponseBody
    public Object login(String username, String password) {
        User user = userService.findByUsername(username);
        if(user == null) {
            return new Result(false, "用户不存在", null);
        }

        if(password == null || !password.equals(user.getPassword())) {
            return new Result(false, "密码错误", null);
        }

        return new Result(true, "登录成功", user.getId());
    }


}
