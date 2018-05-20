package com.eternal.design.service;


import com.eternal.design.entity.Training;
import com.eternal.design.entity.TrainingExample;
import com.eternal.design.page.PageResult;

import java.util.List;

public interface TrainingService {
    PageResult<Training> findByPage(TrainingExample example);

    Training findById(Integer id);

    Training insertOrUpdate(Training training);

    int deleteById(Integer id);

    List<Training> findAll();

    List<Training> findByType(Short type);

    Training findByName(String name);
}
