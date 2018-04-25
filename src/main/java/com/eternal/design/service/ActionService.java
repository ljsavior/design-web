package com.eternal.design.service;

import com.eternal.design.entity.Action;
import com.eternal.design.entity.ActionExample;
import com.eternal.design.page.PageResult;

import java.util.List;

public interface ActionService {
    PageResult<Action> findByPage(ActionExample example);

    Action findById(Integer id);

    Action insertOrUpdate(Action posture);

    int deleteById(Integer id);

    List<Action> findByIds(List<Integer> idList);
}
