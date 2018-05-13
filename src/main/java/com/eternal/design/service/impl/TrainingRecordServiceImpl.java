package com.eternal.design.service.impl;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.entity.TrainingRecordExample;
import com.eternal.design.mapper.TrainingRecordMapper;
import com.eternal.design.page.PageResult;
import com.eternal.design.page.PageUtil;
import com.eternal.design.service.TrainingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingRecordServiceImpl implements TrainingRecordService {
    @Autowired
    private TrainingRecordMapper trainingRecordMapper;

    @Override
    public PageResult<TrainingRecord> findByPage(TrainingRecordExample example) {
        return PageUtil.queryByPage(() -> trainingRecordMapper.countByExample(example), () -> trainingRecordMapper.selectByExample(example));
    }

    @Override
    public TrainingRecord findById(Integer id) {
        return trainingRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertOrUpdate(TrainingRecord trainingRecord) {
        if(trainingRecord.getId() == null) {
            return trainingRecordMapper.insertSelective(trainingRecord);
        } else {
            return trainingRecordMapper.updateByPrimaryKeySelective(trainingRecord);
        }
    }

    @Override
    public int deleteById(Integer id) {
        return trainingRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TrainingRecord> findByExample(TrainingRecordExample example) {
        return trainingRecordMapper.selectByExample(example);
    }
}
