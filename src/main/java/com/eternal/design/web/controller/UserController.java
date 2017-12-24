package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.eternal.design.common.DateFormatUtil;
import com.eternal.design.entity.User;
import com.eternal.design.entity.UserExample;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.UserService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/list.htm")
    public String list() {
        return "user/list";
    }

    @RequestMapping("/user/query.json")
    @ResponseBody
    public Object query(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();


        if(StringUtils.isNotEmpty(username)) {
            criteria.andUsernameEqualTo(username);
        }

        PageResult<User> pageResult = userService.findByPage(example);
        JSONObject result = PageUtil.parseResult(pageResult, user -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(user.getId()));
            row.add(user.getUsername());
            row.add(DateFormatUtil.format(user.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            return row;
        });

        return result;
    }

    @RequestMapping("/user/addOrUpdate.htm")
    public String addOrUpdate(Integer id, Model model) {
        if(id != null) {
            User user = userService.findById(id);
            model.addAttribute("item", user);
        }
        return "user/info";
    }

    @RequestMapping("/user/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(String id, String username, String password, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if(StringUtils.isNotEmpty(id)) {
            user.setId(Integer.parseInt(id));
        }

        userService.insertOrUpdate(user);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/user/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        int res = userService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";
        return new Result(success, msg, null);
    }

    @RequestMapping("/user/usernameList.json")
    @ResponseBody
    public Object usernameList() {
        return userService.findAll().stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }
}
