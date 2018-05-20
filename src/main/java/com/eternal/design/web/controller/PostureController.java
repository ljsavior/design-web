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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostureController {
    @Value("${myConfig.img-file-dir}")
    private String imgFileDir;

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
            row.add(posture.getData());
            row.add(posture.getMark());

            return row;
        });

        return result;
    }

    @RequestMapping("/posture/get.json")
    @ResponseBody
    public Object get(int id) {
        Posture posture = this.postureService.findById(id);
        return new Result(true, "", posture);
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
    public Object addOrUpdate(Posture posture) {
        postureService.insertOrUpdate(posture);

        return new Result(true, "提交成功", null);
    }

    @RequestMapping("/posture/delete.json")
    @ResponseBody
    public Object delete(Integer id) {
        Posture posture = postureService.findById(id);
        int res = postureService.deleteById(id);
        boolean success = res == 1;
        String msg = success ? "删除成功" : "删除失败";

        if(success) {
            try {
                String imgPath = imgFileDir.concat("/").concat(posture.getPicPath());
                Files.deleteIfExists(Paths.get(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return new Result(success, msg, null);
    }
}
