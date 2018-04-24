package com.eternal.design.mapper;

import com.eternal.design.entity.CoachPatientRelationship;
import com.eternal.design.entity.CoachPatientRelationshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoachPatientRelationshipMapper {
    long countByExample(CoachPatientRelationshipExample example);

    int deleteByExample(CoachPatientRelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CoachPatientRelationship record);

    int insertSelective(CoachPatientRelationship record);

    List<CoachPatientRelationship> selectByExample(CoachPatientRelationshipExample example);

    CoachPatientRelationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CoachPatientRelationship record, @Param("example") CoachPatientRelationshipExample example);

    int updateByExample(@Param("record") CoachPatientRelationship record, @Param("example") CoachPatientRelationshipExample example);

    int updateByPrimaryKeySelective(CoachPatientRelationship record);

    int updateByPrimaryKey(CoachPatientRelationship record);
}