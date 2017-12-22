package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.eternal.design.entity.Posture;
import com.eternal.design.entity.PostureExample;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.PostureService;
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
public class PostureController {
    @Autowired
    private PostureService postureService;

    @RequestMapping("/posture/list.htm")
    public String list() {
        return "posture/list";
    }

    @RequestMapping("/posture/query.json")
    @ResponseBody
    public Object query(String name) {
        PostureExample example = new PostureExample();
        PostureExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(name)) {
            criteria.andNameEqualTo(name);
        }

        PageResult<Posture> pageResult = postureService.findByPage(example);
        JSONObject result = PageUtil.parseResult(pageResult, posture -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(posture.getId()));
            row.add(posture.getName());
            row.add(posture.getPicPath());
            row.add(String.valueOf(posture.getType()));
            row.add(posture.getData());

            return row;
        });

        return result;
    }

    @RequestMapping("/posture/addOrUpdate.htm")
    public String addOrUpdate(Integer id, Model model) {
        if(id != null) {
            Posture posture = postureService.findById(id);
            model.addAttribute("item", posture);
        }
        return "posture/info";
    }

    @RequestMapping("/posture/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(String id, String name, String picPath, Byte type, String data, Model model) {
        Posture posture = new Posture();
        posture.setName(name);
        posture.setPicPath(picPath);
        posture.setType(type);
        posture.setData(data);

        if(StringUtils.isNotEmpty(id)) {
            posture.setId(Integer.parseInt(id));
        }

        postureService.insertOrUpdate(posture);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/posture/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        int res = postureService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";
        return new Result(success, msg, null);
    }
}