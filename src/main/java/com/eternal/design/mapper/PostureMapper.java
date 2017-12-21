package com.eternal.design.mapper;

import com.eternal.design.entity.Posture;
import com.eternal.design.entity.PostureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostureMapper {
    long countByExample(PostureExample example);

    int deleteByExample(PostureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Posture record);

    int insertSelective(Posture record);

    List<Posture> selectByExampleWithBLOBs(PostureExample example);

    List<Posture> selectByExample(PostureExample example);

    Posture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Posture record, @Param("example") PostureExample example);

    int updateByExampleWithBLOBs(@Param("record") Posture record, @Param("example") PostureExample example);

    int updateByExample(@Param("record") Posture record, @Param("example") PostureExample example);

    int updateByPrimaryKeySelective(Posture record);

    int updateByPrimaryKeyWithBLOBs(Posture record);

    int updateByPrimaryKey(Posture record);
}