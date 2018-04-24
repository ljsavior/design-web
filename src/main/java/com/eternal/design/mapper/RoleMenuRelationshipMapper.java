package com.eternal.design.mapper;

import com.eternal.design.entity.RoleMenuRelationship;
import com.eternal.design.entity.RoleMenuRelationshipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuRelationshipMapper {
    long countByExample(RoleMenuRelationshipExample example);

    int deleteByExample(RoleMenuRelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuRelationship record);

    int insertSelective(RoleMenuRelationship record);

    List<RoleMenuRelationship> selectByExample(RoleMenuRelationshipExample example);

    RoleMenuRelationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleMenuRelationship record, @Param("example") RoleMenuRelationshipExample example);

    int updateByExample(@Param("record") RoleMenuRelationship record, @Param("example") RoleMenuRelationshipExample example);

    int updateByPrimaryKeySelective(RoleMenuRelationship record);

    int updateByPrimaryKey(RoleMenuRelationship record);
}