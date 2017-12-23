package com.eternal.design.service.impl;

import com.eternal.design.entity.Training;
import com.eternal.design.entity.TrainingExample;
import com.eternal.design.mapper.TrainingMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    public PageResult<Training> findByPage(TrainingExample example) {
        return PageUtil.queryByPage(() -> trainingMapper.countByExample(example), () -> trainingMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public Training findById(Integer id) {
        return trainingMapper.selectByPrimaryKey(id);
    }

    @Override
    public Training insertOrUpdate(Training training) {
        if(training.getId() == null) {
            trainingMapper.insertSelective(training);
        } else {
            trainingMapper.updateByPrimaryKeySelective(training);
        }
        return training;
    }

    @Override
    public int deleteById(Integer id) {
        return trainingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Training> findAll() {
        return trainingMapper.selectByExampleWithBLOBs(new TrainingExample());
    }

    @Override
    public Training findByName(String name) {
        TrainingExample example = new TrainingExample();
        TrainingExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(name);

        return trainingMapper.selectByExampleWithBLOBs(example).stream()
                .findFirst()
                .orElse(null);
    }

}
