package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eternal.design.entity.Posture;
import com.eternal.design.entity.Training;
import com.eternal.design.service.PostureService;
import com.eternal.design.service.TrainingService;
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
    public Object nameList() {
        List<String> nameList = trainingService.findAll()
                .stream()
                .map(Training::getName)
                .collect(Collectors.toList());

        return nameList;
    }

    @RequestMapping("/client/training/getTrainingData.json")
    @ResponseBody
    public Object getTrainingData(HttpServletRequest request, String name) {
        JSONArray result = new JSONArray();

        if(StringUtils.isEmpty(name)) {
            return result;
        }

        Training training = trainingService.findByName(name);

        if(training == null) {
            return result;
        }

        JSONArray postures = JSONArray.parseArray(training.getPostures());

        List<Integer> idList = new ArrayList<>(postures.size());
        for(int i = 0; i < postures.size(); i++) {
            idList.add(postures.getInteger(i));
        }

        List<Posture> postureList = postureService.findByIds(idList);

        postureList.forEach(pos -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("img", host + "/getImage/" + pos.getPicPath());
            jsonObject.put("data", JSONObject.parseObject(pos.getData()));
            result.add(jsonObject);
        });

        return result;
    }
}
