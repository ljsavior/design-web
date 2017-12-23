package com.eternal.design.mapper;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.entity.TrainingRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainingRecordMapper {
    long countByExample(TrainingRecordExample example);

    int deleteByExample(TrainingRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainingRecord record);

    int insertSelective(TrainingRecord record);

    List<TrainingRecord> selectByExample(TrainingRecordExample example);

    TrainingRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainingRecord record, @Param("example") TrainingRecordExample example);

    int updateByExample(@Param("record") TrainingRecord record, @Param("example") TrainingRecordExample example);

    int updateByPrimaryKeySelective(TrainingRecord record);

    int updateByPrimaryKey(TrainingRecord record);
}