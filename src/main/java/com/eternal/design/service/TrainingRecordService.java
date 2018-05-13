package com.eternal.design.service;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.entity.TrainingRecordExample;
import com.eternal.design.page.PageResult;

import java.util.List;

public interface TrainingRecordService {
    PageResult<TrainingRecord> findByPage(TrainingRecordExample example);

    TrainingRecord findById(Integer id);

    int insertOrUpdate(TrainingRecord trainingRecord);

    int deleteById(Integer id);

    List<TrainingRecord> findByExample(TrainingRecordExample example);
}
