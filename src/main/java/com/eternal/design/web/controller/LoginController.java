package com.eternal.design.web.controller;

import com.eternal.design.entity.User;
import com.eternal.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }


    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(User user, HttpSession session) {
        User u = userService.findByUsername(user.getUsername());
        if(u != null && u.getPassword().equals(user.getPassword())) {
            session.setAttribute("current_user", u);
            return "redirect:/";
        }
        return "login/login";
    }

}
