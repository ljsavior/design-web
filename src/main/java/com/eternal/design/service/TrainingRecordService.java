package com.eternal.design.service;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.entity.TrainingRecordExample;
import com.eternal.design.page.PageResult;

public interface TrainingRecordService {
    PageResult<TrainingRecord> findByPage(TrainingRecordExample example);

    TrainingRecord findById(Integer id);

    TrainingRecord insertOrUpdate(TrainingRecord trainingRecord);

    int deleteById(Integer id);
}
