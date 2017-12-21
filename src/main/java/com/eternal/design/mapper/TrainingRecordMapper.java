package com.eternal.design.mapper;

import com.eternal.design.entity.TrainingRecord;
import com.eternal.design.entity.TrainingRecordExample;
import com.eternal.design.entity.TrainingRecordWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainingRecordMapper {
    long countByExample(TrainingRecordExample example);

    int deleteByExample(TrainingRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainingRecordWithBLOBs record);

    int insertSelective(TrainingRecordWithBLOBs record);

    List<TrainingRecordWithBLOBs> selectByExampleWithBLOBs(TrainingRecordExample example);

    List<TrainingRecord> selectByExample(TrainingRecordExample example);

    TrainingRecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainingRecordWithBLOBs record, @Param("example") TrainingRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") TrainingRecordWithBLOBs record, @Param("example") TrainingRecordExample example);

    int updateByExample(@Param("record") TrainingRecord record, @Param("example") TrainingRecordExample example);

    int updateByPrimaryKeySelective(TrainingRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TrainingRecordWithBLOBs record);

    int updateByPrimaryKey(TrainingRecord record);
}