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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    private Map<Short, String> roleMap = new HashMap<>();

    @PostConstruct
    public void init() {
        roleMap.put((short)0, "管理员");
        roleMap.put((short)1, "康复教练");
        roleMap.put((short)2, "病患");
    }


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
        List<Integer> ids = pageResult.getData().stream()
                .filter(u -> u.getRole() == 2)
                .map(User::getId)
                .collect(Collectors.toList());
        Map<Integer, User> coachMap = userService.findCoachByPatientIdList(ids);


        JSONObject result = PageUtil.parseResult(pageResult, user -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(user.getId()));
            row.add(user.getUsername());
            row.add(roleMap.get(user.getRole()));
            row.add(user.getSex() == 0 ? "男" : "女");
            row.add(user.getName());
            row.add(user.getBirthday());
            row.add(user.getMobilePhone());
            row.add(user.getMark());
            if(user.getRole() == 2) {
                row.add(coachMap.containsKey(user.getId()) ? coachMap.get(user.getId()).getName() : "");
            } else {
                row.add("---");
            }
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

            if(user.getRole() == 2) {
                UserExample userExample = new UserExample();
                userExample.createCriteria().andRoleEqualTo((short)1);
                List<User> coachList = userService.findByExample(userExample);

                model.addAttribute("coachList", coachList);

                User coach = userService.findCoachByPatientId(id);
                if(coach != null) {
                    model.addAttribute("coachId", coach.getId());
                }
            }

        }
        return "user/info";
    }

    @RequestMapping("/user/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(User user, Integer coachId, Model model) {
        userService.insertOrUpdate(user);

        userService.seCoachPatientRelationship(coachId, user.getId());

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



    @RequestMapping("/user/patientList.htm")
    public String patientList() {
        return "user/patientList";
    }

    @RequestMapping("/user/patientQuery.json")
    @ResponseBody
    public Object patientQuery(String username, HttpSession session) {
        User currentUser = (User)session.getAttribute("current_user");

        List<Integer> idList = userService.findPatientIdListByCoachId(currentUser.getId());

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(!CollectionUtils.isEmpty(idList)) {
            criteria.andIdIn(idList);
        }

        if(StringUtils.isNotEmpty(username)) {
            criteria.andUsernameEqualTo(username);
        }

        PageResult<User> pageResult = userService.findByPage(example);


        JSONObject result = PageUtil.parseResult(pageResult, user -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(user.getId()));
            row.add(user.getUsername());
            row.add(user.getSex() == 0 ? "男" : "女");
            row.add(user.getName());
            row.add(user.getBirthday());
            row.add(user.getMobilePhone());
            row.add(user.getMark());
            row.add(DateFormatUtil.format(user.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            return row;
        });

        return result;
    }
}
