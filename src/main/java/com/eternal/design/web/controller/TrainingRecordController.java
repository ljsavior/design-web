package com.eternal.design.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eternal.design.common.DateFormatUtil;
import com.eternal.design.entity.*;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.PostureService;
import com.eternal.design.service.TrainingRecordService;
import com.eternal.design.service.TrainingService;
import com.eternal.design.service.UserService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class TrainingRecordController {

    @Autowired
    private TrainingRecordService trainingRecordService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private PostureService postureService;

    @Autowired
    private UserService userService;



    @RequestMapping("/trainingRecord/list.htm")
    public String list(HttpServletRequest request) {
        User currentUser = (User)request.getSession().getAttribute("current_user");
        List<User> patientList = userService.findPatientListByCoachId(currentUser.getId());
        if(!CollectionUtils.isEmpty(patientList)) {
            request.setAttribute("patientList", patientList);
        }

        return "trainingRecord/list";
    }

    @RequestMapping("/trainingRecord/query.json")
    @ResponseBody
    public Object query(Integer patientId, String trainingName, Short trainingType, HttpSession session) {
        User currentUser = (User) session.getAttribute("current_user");

        List<User> patientList = userService.findPatientListByCoachId(currentUser.getId());
        if(CollectionUtils.isEmpty(patientList)) {
            return PageUtil.emptyResult();
        }

        Map<Integer, String> idUsernameMap = patientList.stream()
                .collect(Collectors.toMap(User::getId, User::getUsername));

        TrainingRecordExample example = new TrainingRecordExample();
        TrainingRecordExample.Criteria criteria = example.createCriteria();

        if(patientId != null) {
            criteria.andUserIdEqualTo(patientId);
        }
        if(StringUtils.isNotEmpty(trainingName)) {
            criteria.andTrainingNameEqualTo(trainingName);
        }
        if(trainingType != null) {
            criteria.andTrainingTypeEqualTo(trainingType);
        }

        PageResult<TrainingRecord> pageResult = trainingRecordService.findByPage(example);
        JSONObject result = PageUtil.parseResult(pageResult, trainingRecord -> {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(trainingRecord.getId()));
            row.add(idUsernameMap.getOrDefault(trainingRecord.getUserId(), ""));
            row.add(trainingRecord.getTrainingName());
            row.add(trainingRecord.getTrainingType() == 0 ? "姿势训练" : "动作训练");
            row.add(trainingRecord.getTimesUsed());
            row.add(trainingRecord.getResult());
            row.add(DateFormatUtil.format(trainingRecord.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));

            return row;
        });

        return result;
    }

    @RequestMapping("/trainingRecord/detailBar.htm")
    public String detailBar(Integer id, Model model) {
        model.addAttribute("id", id);
        return "trainingRecord/detailBar";
    }

    @RequestMapping("/trainingRecord/timesUsedBar.json")
    @ResponseBody
    public Object timesUsedBar(Integer id) {
        TrainingRecord trainingRecord = this.trainingRecordService.findById(id);
        String trainingName = trainingRecord.getTrainingName();

        Training training = trainingService.findByName(trainingName);
        JSONArray postureIdJsonArray = JSONArray.parseArray(training.getPostures());
        List<Integer> idList = new ArrayList<>(postureIdJsonArray.size());
        for(int i = 0; i < postureIdJsonArray.size(); i++) {
            idList.add(postureIdJsonArray.getInteger(i));
        }
        List<String> postureNamesList = postureService.findByIds(idList).stream()
                .map(Posture::getName)
                .collect(Collectors.toList());


        JSONArray timesUsed = JSONArray.parseArray(trainingRecord.getTimesUsed());


        User patient = userService.findById(trainingRecord.getUserId());

        JSONObject resData = new JSONObject();
        resData.put("username", patient.getUsername());
        resData.put("trainingName", trainingName);
        resData.put("xAxis", postureNamesList);
        resData.put("series", timesUsed);

        return new Result(true, "", resData);
    }

    @RequestMapping("/trainingRecord/resultBar.json")
    @ResponseBody
    public Object resultBar(Integer id) {
        TrainingRecord trainingRecord = this.trainingRecordService.findById(id);

        String trainingName = trainingRecord.getTrainingName();

        Training training = trainingService.findByName(trainingName);
        JSONArray postureIdJsonArray = JSONArray.parseArray(training.getPostures());
        List<Integer> idList = new ArrayList<>(postureIdJsonArray.size());
        for(int i = 0; i < postureIdJsonArray.size(); i++) {
            idList.add(postureIdJsonArray.getInteger(i));
        }
        List<String> postureNamesList = postureService.findByIds(idList).stream()
                .map(Posture::getName)
                .collect(Collectors.toList());


        JSONArray result = JSONArray.parseArray(trainingRecord.getResult());

        User patient = userService.findById(trainingRecord.getUserId());

        JSONObject resData = new JSONObject();
        resData.put("username", patient.getUsername());
        resData.put("trainingName", trainingName);
        resData.put("xAxis", postureNamesList);
        resData.put("series", result);

        return new Result(true, "", resData);
    }

    @RequestMapping("/trainingRecord/trend.htm")
    public String trend() {
        return "trainingRecord/trend";
    }


    @RequestMapping("/trainingRecord/trend.json")
    @ResponseBody
    public Object trend(Integer userId, Short trainingType) {
        TrainingRecordExample example = new TrainingRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andTrainingTypeEqualTo(trainingType);
        example.setOrderByClause("create_time asc");

        List<TrainingRecord> trainingRecordList = trainingRecordService.findByExample(example);

        List<String> createTimeList = trainingRecordList.stream()
                .map(TrainingRecord::getCreateTime)
                .map(date -> DateFormatUtil.format(date, "yyyy-MM-dd HH:mm:ss"))
                .collect(Collectors.toList());

        List<Integer> timeUsedList = trainingRecordList.stream()
                .map(TrainingRecord::getTimesUsed)
                .map(JSONArray::parseArray)
                .map(array -> {
                    int sum = 0;
                    for (int i = 0; i < array.size(); i++) {
                        sum += array.getInteger(i);
                    }
                    return sum;
                })
                .collect(Collectors.toList());

        List<Integer> completeRateList = trainingRecordList.stream()
                .map(TrainingRecord::getResult)
                .map(JSONArray::parseArray)
                .map(array -> {
                    int sum = 0;
                    for (int i = 0; i < array.size(); i++) {
                        sum += array.getInteger(i);
                    }
                    return sum * 100 / array.size();
                })
                .collect(Collectors.toList());

        User patient = userService.findById(userId);

        JSONObject resData = new JSONObject();
        resData.put("username", patient.getUsername());
        resData.put("createTimeList", createTimeList);
        resData.put("timeUsedList", timeUsedList);
        resData.put("completeRateList", completeRateList);

        return new Result(true, "", resData);
    }


}
