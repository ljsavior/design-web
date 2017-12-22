package com.eternal.design.service;


import com.eternal.design.entity.Training;
import com.eternal.design.entity.TrainingExample;
import com.eternal.design.page.PageResult;

public interface TrainingService {
    PageResult<Training> findByPage(TrainingExample example);

    Training findById(Integer id);

    Training insertOrUpdate(Training training);

    int deleteById(Integer id);
}
