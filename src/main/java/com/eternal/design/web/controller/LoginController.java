package com.eternal.design.web.controller;

import com.eternal.design.entity.Menu;
import com.eternal.design.entity.User;
import com.eternal.design.service.MenuService;
import com.eternal.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }


    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request) {
        User u = userService.findByUsername(user.getUsername());
        if(u != null && u.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("current_user", u);

            List<Menu> menuList = menuService.selectByUser(u);
            request.getSession().setAttribute("current_user_menuList", menuList);
            return "redirect:/";
        }
        request.setAttribute("item", user);
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("current_user");
        session.removeAttribute("current_user_menuList");
        return "redirect:/login.htm";
    }

}
