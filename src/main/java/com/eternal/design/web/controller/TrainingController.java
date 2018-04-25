package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.eternal.design.common.DateFormatUtil;
import com.eternal.design.entity.Training;
import com.eternal.design.entity.TrainingExample;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.TrainingService;
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
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @RequestMapping("/training/list.htm")
    public String list() {
        return "training/list";
    }

    @RequestMapping("/training/query.json")
    @ResponseBody
    public Object query(String name, Short type) {
        TrainingExample example = new TrainingExample();
        TrainingExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(name)) {
            criteria.andNameEqualTo(name);
        }
        if(type != null) {
            criteria.andTypeEqualTo(type);
        }

        PageResult<Training> pageResult = trainingService.findByPage(example);
        JSONObject result = PageUtil.parseResult(pageResult, training -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(training.getId()));
            row.add(training.getName());
            row.add(training.getType() == 0 ? "姿势训练" : "动作训练");
            row.add(training.getPostures());
            row.add(DateFormatUtil.format(training.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));

            return row;
        });

        return result;
    }

    @RequestMapping("/training/addOrUpdate.htm")
    public String addOrUpdate(Integer id, Model model) {
        if(id != null) {
            Training training = trainingService.findById(id);
            model.addAttribute("item", training);
        }
        return "training/info";
    }

    @RequestMapping("/training/addOrUpdate.json")
    @ResponseBody
    public Object addOrUpdate(Training training) {
        trainingService.insertOrUpdate(training);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/training/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        int res = trainingService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";
        return new Result(success, msg, null);
    }
}
