package com.eternal.design.web.controller;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.service.TrainingRecordService;
import com.eternal.design.web.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientTrainingDataRecordController {

    @Autowired
    private TrainingRecordService trainingRecordService;

    @RequestMapping("/client/trainingRecord/upload.json")
    @ResponseBody
    public Object upload(TrainingRecord trainingRecord) {
        if(trainingRecord.getUserId() == null) {
            return new Result(false, "用户未登录", null);
        }

        trainingRecordService.insertOrUpdate(trainingRecord);

        return new Result(true, "训练记录上传成功", null);
    }

}
