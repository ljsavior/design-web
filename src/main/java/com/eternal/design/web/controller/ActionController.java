package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.eternal.design.entity.Action;
import com.eternal.design.entity.ActionExample;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.ActionService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActionController {
    @Autowired
    private ActionService actionService;

    @RequestMapping("/action/list.htm")
    public String list() {
        return "action/list";
    }

    @RequestMapping("/action/query.json")
    @ResponseBody
    public Object query(String name) {
        ActionExample example = new ActionExample();
        ActionExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(name)) {
            criteria.andNameEqualTo(name);
        }

        PageResult<Action> pageResult = actionService.findByPage(example);
        JSONObject result = PageUtil.parseResult(pageResult, action -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(action.getId()));
            row.add(action.getName());
            row.add(action.getMark());

            return row;
        });

        return result;
    }

    @RequestMapping("/action/addOrUpdate.htm")
    public String addOrUpdate(Integer id, Model model) {
        if(id != null) {
            Action action = actionService.findById(id);
            model.addAttribute("item", action);
        }
        return "action/info";
    }

    @RequestMapping("/action/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(Action action) {
        actionService.insertOrUpdate(action);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/action/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        int res = actionService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";
        return new Result(success, msg, null);
    }
}
