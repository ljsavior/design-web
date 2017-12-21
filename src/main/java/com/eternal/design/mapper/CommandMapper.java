package com.eternal.design.mapper;

import com.eternal.design.entity.Command;
import com.eternal.design.entity.CommandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommandMapper {
    long countByExample(CommandExample example);

    int deleteByExample(CommandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Command record);

    int insertSelective(Command record);

    List<Command> selectByExample(CommandExample example);

    Command selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Command record, @Param("example") CommandExample example);

    int updateByExample(@Param("record") Command record, @Param("example") CommandExample example);

    int updateByPrimaryKeySelective(Command record);

    int updateByPrimaryKey(Command record);
}