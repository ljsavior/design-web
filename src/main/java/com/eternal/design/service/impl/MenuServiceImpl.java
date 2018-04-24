package com.eternal.design.service.impl;

import com.eternal.design.entity.*;
import com.eternal.design.mapper.MenuMapper;
import com.eternal.design.mapper.RoleMenuRelationshipMapper;
import com.eternal.design.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMenuRelationshipMapper roleMenuRelationshipMapper;

    @Override
    public List<Menu> selectByUser(User user) {
        RoleMenuRelationshipExample roleMenuRelationshipExample = new RoleMenuRelationshipExample();
        roleMenuRelationshipExample.createCriteria().andRoleEqualTo(user.getRole());
        List<Integer> menuIdList = roleMenuRelationshipMapper.selectByExample(roleMenuRelationshipExample).stream()
                .map(RoleMenuRelationship::getMenuId)
                .collect(Collectors.toList());

        MenuExample example = new MenuExample();
        example.createCriteria().andIdIn(menuIdList);

        return menuMapper.selectByExample(example);
    }
}
