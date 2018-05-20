package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eternal.design.entity.Posture;
import com.eternal.design.entity.Training;
import com.eternal.design.service.PostureService;
import com.eternal.design.service.TrainingService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ClientTrainingController {

    @Value("${myConfig.host}")
    private String host;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private PostureService postureService;


    @RequestMapping("/client/training/nameList.json")
    @ResponseBody
    public Object nameList(Short type) {
        List<String> nameList = trainingService.findByType(type)
                .stream()
                .map(Training::getName)
                .collect(Collectors.toList());

        return nameList;
    }

    @RequestMapping("/client/training/get.json")
    @ResponseBody
    public Object getTrainingData(String name) {
        if(StringUtils.isEmpty(name)) {
            return new Result(false, "", null);
        }

        Training training = trainingService.findByName(name);
        return new Result(true, "", training);
    }
}
